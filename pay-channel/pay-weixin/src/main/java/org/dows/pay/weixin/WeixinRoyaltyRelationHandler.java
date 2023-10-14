package org.dows.pay.weixin;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.binarywang.wxpay.bean.ecommerce.*;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.v3.util.RsaCryptoUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.dows.framework.api.exceptions.BizException;
import org.dows.order.api.OrderInstanceBizApiService;
import org.dows.order.bo.OrderInstanceBo;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.request.ProfitReceiverAddReq;
import org.dows.pay.api.request.SeparateAccountReq;
import org.dows.pay.bo.RelationBingBo;
import org.dows.pay.boot.PayClientConfig;
import org.dows.pay.entity.PayAccount;
import org.dows.pay.entity.PayLedgers;
import org.dows.pay.entity.PayLedgersRecord;
import org.dows.pay.entity.PayTransaction;
import org.dows.pay.mapper.PayLedgersRecordMapper;
import org.dows.pay.service.PayAccountService;
import org.dows.pay.service.PayLedgersService;
import org.dows.pay.service.PayTransactionService;
import org.dows.store.api.MerchantInstanceApi;
import org.dows.store.api.StoreInstanceApi;
import org.dows.store.api.response.MerchantResponse;
import org.dows.store.api.response.StoreResponse;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 微信分账关系维护
 * <p>
 * TRADE_ROYALTY_RELATION_BIND("dows.trade.royalty.relation.bind", "", "分账关系绑定"),
 * TRADE_ROYALTY_RELATION_UNBIND("dows.trade.royalty.relation.unbind", "", "分账关系解绑"),
 * TRADE_ROYALTY_RELATION_QUERY("dows.trade.royalty.relation.query", "", "分账关系查询"),
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class WeixinRoyaltyRelationHandler extends AbstractWeixinHandler {
    private static final Gson GSON = new GsonBuilder().create();
    private final PayLedgersService payLedgersService;

    private final PayAccountService payAccountService;

    private final PayClientConfig payClientConfig;

    private final StoreInstanceApi storeInstanceApi;

    private final MerchantInstanceApi merchantInstanceApi;

    private final PayTransactionService payTransactionService;

    private final PayLedgersRecordMapper payLedgersRecordMapper;


    private final OrderInstanceBizApiService orderInstanceBizApiService;



    /**
     * 分账完成
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_ROYALTY_RELATION_FINISH)
    public void tradeRoyaltyFinish(PayRequest payRequest) {
        FinishOrderRequest finishOrderRequest = GSON.fromJson(GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), FinishOrderRequest.class);
        String url = String.format("%s/v3/ecommerce/profitsharing/finish-order", this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl());
        try {
            String response = this.getWeixinClient(payRequest.getAppId()).postV3(url, GSON.toJson(finishOrderRequest));
            ProfitSharingResult profitSharingResult = GSON.fromJson(response, ProfitSharingResult.class);
        } catch (WxPayException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 分账申请
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_ROYALTY_RELATION_APPLY)
    public void tradeRoyaltyApply(PayRequest payRequest) {
        ProfitSharingRequest profitSharingRequest = GSON.fromJson(GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), ProfitSharingRequest.class);
        String url = String.format("%s/v3/ecommerce/profitsharing/orders", this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl());
        try {
            RsaCryptoUtil.encryptFields(profitSharingRequest, this.getWeixinClient(payRequest.getAppId()).getConfig().getVerifier().getValidCertificate());
            String response = this.getWeixinClient(payRequest.getAppId()).postV3WithWechatpaySerial(url, GSON.toJson(profitSharingRequest));
            ProfitSharingResult profitSharingResult = GSON.fromJson(response, ProfitSharingResult.class);
        } catch (WxPayException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 分账查询
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_ROYALTY_RELATION_QUERY)
    public void tradeRoyaltyQuery(PayRequest payRequest) {
        ProfitSharingQueryRequest profitSharingQueryRequest = GSON.fromJson(GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), ProfitSharingQueryRequest.class);
        String url = String.format("%s/v3/ecommerce/profitsharing/orders?sub_mchid=%s&transaction_id=%s&out_order_no=%s"
                , this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl()
                , profitSharingQueryRequest.getSubMchid()
                , profitSharingQueryRequest.getTransactionId()
                , profitSharingQueryRequest.getOutOrderNo());
        try {
            String response = this.getWeixinClient(payRequest.getAppId()).getV3(url);
            ProfitSharingResult profitSharingResult = GSON.fromJson(response, ProfitSharingResult.class);
        } catch (WxPayException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 分账关系绑定
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_ROYALTY_RELATION_BIND)
    public void tradeRoyaltyRelationBind(PayRequest payRequest) {
        RelationBingBo relationBingBo = (RelationBingBo)payRequest.getBizModel();
        ProfitSharingReceiverRequest profitSharingReceiverRequest = new ProfitSharingReceiverRequest();
        profitSharingReceiverRequest.setRelationType("SERVICE_PROVIDER");
        profitSharingReceiverRequest.setAccount(relationBingBo.getChannelAccountNo());
        profitSharingReceiverRequest.setAppid(relationBingBo.getAppId());
        profitSharingReceiverRequest.setType("MERCHANT_ID");
        String url =String.format("%s/v3/ecommerce/profitsharing/receivers/add",this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl());
        try {
            String response = this.getWeixinClient(payRequest.getAppId()).postV3(url, GSON.toJson(profitSharingReceiverRequest));
            ProfitSharingReceiverResult profitSharingReceiverResult = GSON.fromJson(response, ProfitSharingReceiverResult.class);
            //更新分账关系表
            PayLedgers payLedgers = new PayLedgers();
            payLedgers.setAccountId(relationBingBo.getAppId());
            payLedgers.setAllocationProfit(new BigDecimal(0.01d));
            payLedgers.setAppId(relationBingBo.getAppId());
            payLedgers.setChannelAccountNo(relationBingBo.getChannelAccountNo());
            payLedgersService.saveOrUpdate(payLedgers);
        } catch (WxPayException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 分账关系删除
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_ROYALTY_RELATION_UNBIND)
    public void tradeRoyaltyRelationUnbind(PayRequest payRequest) {
        ProfitSharingReceiverRequest profitSharingReceiverRequest = GSON.fromJson
                (GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), ProfitSharingReceiverRequest.class);
        String url =String.format("%s/v3/ecommerce/profitsharing/receivers/delete",this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl());
        try {
            String response = this.getWeixinClient(payRequest.getAppId()).postV3(url, GSON.toJson(profitSharingReceiverRequest));
            ProfitSharingReceiverResult profitSharingReceiverResult = GSON.fromJson(response, ProfitSharingReceiverResult.class);
        } catch (WxPayException e) {
            throw new RuntimeException(e);
        }
    }

        public void claimProfit(String orderId,Integer amount,String transactionId,String transactionNo,String appId) {
       log.info("orderId={},amount={},transactionId={},transactionNo={},appId={} ask claimProfit",
               orderId,amount,transactionId,transactionNo, appId);
        PayAccount payAccount = payAccountService.lambdaQuery()
                .eq(PayAccount::getChannelAccount,appId)
                .eq(PayAccount::getDeleted,0)
                .orderByDesc(PayAccount::getId)
                .last(" limit 1").one();
        if (payAccount == null) {
            log.error("通过appId={} 查询支付账号信息为空,无法进行分账",appId);
            return;
        }

        OrderInstanceBo orderInstanceBo = orderInstanceBizApiService.getOne(orderId,true);
        if (orderInstanceBo == null) {
            log.error("通过orderId={} 查询订单信息为空,无法进行分账",orderId);
            return;
        }

        PayLedgers payLedgers = payLedgersService.lambdaQuery()
                .eq(PayLedgers::getAppId, "wx1f2863eb6cdee6a1")
                .eq(PayLedgers::getChannelAppId, appId)
                .orderByDesc(PayLedgers::getId).one();
        Optional.ofNullable(payLedgers).orElseGet(()->{
            ProfitReceiverAddReq req = new ProfitReceiverAddReq()
                    .setAppid("wx1f2863eb6cdee6a1")
                    .setSub_mchid(payAccount.getChannelMerchantNo())
                    .setName("上海有星科技有限公司")
                    .setAccount("1604404392")
                    .setType("MERCHANT_ID")
                    .setRelation_type("SERVICE_PROVIDER");
            if (addProfitReceiver(req)) {
                PayLedgers adPayLedgers = new PayLedgers();
                adPayLedgers.setMerchantNo(payAccount.getMerchantNo());
                adPayLedgers.setAppId("wx1f2863eb6cdee6a1");
                adPayLedgers.setAccountId("1604404392");
                adPayLedgers.setAccountName("上海有星科技有限公司");
                adPayLedgers.setChannelCode("weixin");
                adPayLedgers.setChannelAppId(appId);
                adPayLedgers.setChannelAccountNo(payAccount.getChannelMerchantNo());
                adPayLedgers.setChannelAccountType(true);
                adPayLedgers.setState(true);
                adPayLedgers.setCreateTime(new Date());
                adPayLedgers.setDeleted(false);
                payLedgersService.save(adPayLedgers);
            }
            return null;
        });

        StoreResponse storeById = storeInstanceApi.getStoreById(orderInstanceBo.getStoreId());
        if (storeById == null) {
            log.error("根据storeId={} 查询门店信息为空,无法进行分账",orderInstanceBo.getStoreId());
            return;
        }


        MerchantResponse merchantResponse = merchantInstanceApi.getMerchantByNo(storeById.getMerchantNo());

        if (merchantResponse.getCommissionRatio() == null) {
            log.error("根据merchantId={} 查询商户分账比例为空,无法进行分账",storeById.getMerchantNo());
            return;
        }


        List<SeparateAccountReq.Receivers> receivers = new ArrayList<>();
        BigDecimal separateAmount = orderInstanceBo.getAgreeAmout().multiply(new BigDecimal("100"));
        int profitAmount = separateAmount.multiply(BigDecimal.valueOf(merchantResponse.getCommissionRatio()))
                .divide(new BigDecimal("100"),2, RoundingMode.CEILING).intValue();
        PayLedgersRecord payLedgersRecord = addPayLedgerRecord(payAccount, orderId, profitAmount, appId, merchantResponse.getCommissionRatio());
        SeparateAccountReq.Receivers  receiver = SeparateAccountReq.Receivers.builder()
                .type("MERCHANT_ID")
                .account("1604404392")// 应该分给服务商
                .amount(profitAmount) // 分账金额
                .description("分给服务商")
                .build();
        receivers.add(receiver);
        SeparateAccountReq profitSharingRequest =  SeparateAccountReq.builder()
                .receivers(receivers)
                .out_order_no(transactionNo)
                .transaction_id(transactionId)
                .appid("wx1f2863eb6cdee6a1")
                .sub_mchid(payAccount.getChannelMerchantNo())
                .unfreeze_unsplit(true)
                .finish(true)
                .build();

        try {
           log.info("订单id发起分账 {}:{}",orderId,JSON.toJSONString(profitSharingRequest));
            HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/v3/profitsharing/orders");
            StringEntity stringEntity = new StringEntity(JSON.toJSONString(profitSharingRequest), ContentType.create("application/json", "utf-8"));
            httpPost.setEntity(stringEntity);
            CloseableHttpClient httpClient = this.getWeixinClient(payClientConfig.getClientConfigs().get(1)
                    .getAppId()).getConfig().getApiV3HttpClient();
            String apiV3Key = this.getWeixinClient(payClientConfig.getClientConfigs().get(1).getAppId()).getConfig()
                    .getVerifier().getValidCertificate().getSerialNumber().toString(16).toUpperCase();

            httpPost.addHeader("Accept", "application/json");
            httpPost.addHeader("Content-Type", "application/json");
            httpPost.addHeader("Wechatpay-Serial", apiV3Key);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String res = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            System.out.println("profitSharing result is:"+res);

            JSONObject jsonObject = JSONObject.parseObject(res);
            payLedgersRecord.setResult(res);
            payLedgersRecord.setState(jsonObject.getString("state")==null?0:1);
            payLedgersRecordMapper.updateById(payLedgersRecord);
        } catch (IOException e) {
           log.error("profitSharing error:",e);
        }
    }

    private PayLedgersRecord addPayLedgerRecord(PayAccount payAccount,String orderId, Integer amount, String appId,Double allocationProfit) {
        PayLedgersRecord payLedgersRecord = new PayLedgersRecord();
        payLedgersRecord.setMerchantNo(payAccount.getMerchantNo());
        payLedgersRecord.setAppId("wx1f2863eb6cdee6a1");
        payLedgersRecord.setOrderId(orderId);
        payLedgersRecord.setAccountId("1604404392");
        payLedgersRecord.setAccountName("上海有星科技有限公司");
        payLedgersRecord.setChannelCode("weixin");
        payLedgersRecord.setChannelAppId(appId);
        payLedgersRecord.setChannelAccountNo(payAccount.getChannelMerchantNo());
        payLedgersRecord.setChannelAccountType(true);
        payLedgersRecord.setAllocationProfit(BigDecimal.valueOf(allocationProfit));
        payLedgersRecord.setAmount(new BigDecimal(amount));
        payLedgersRecord.setCreateTime(new Date());
        payLedgersRecordMapper.insert(payLedgersRecord);
        return payLedgersRecord;
    }

    public Boolean addProfitReceiver(ProfitReceiverAddReq req) {
        try {
            req.setName(rsaEncryptOAEP(req.getName(),this.getWeixinClient(payClientConfig.getClientConfigs().get(1).getAppId()).getConfig().getVerifier().getValidCertificate()));
            HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/v3/profitsharing/receivers/add");
            StringEntity stringEntity = new StringEntity(JSON.toJSONString(req), ContentType.create("application/json", "utf-8"));
            httpPost.setEntity(stringEntity);
            CloseableHttpClient httpClient = this.getWeixinClient(payClientConfig.getClientConfigs().get(1)
                    .getAppId()).getConfig().getApiV3HttpClient();
            String apiV3Key = this.getWeixinClient(payClientConfig.getClientConfigs().get(1).getAppId()).getConfig()
                    .getVerifier().getValidCertificate().getSerialNumber().toString(16).toUpperCase();

            httpPost.addHeader("Accept", "application/json");
            httpPost.addHeader("Content-Type", "application/json");
            httpPost.addHeader("Wechatpay-Serial", apiV3Key);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String res = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            System.out.println("profitSharing result is:"+res);
            JSONObject jsonObject = JSONObject.parseObject(res);
            String type = jsonObject.getString("type");
            if (StrUtil.isNotEmpty(type)) {
                return Boolean.TRUE;
            }
        } catch (Exception e) {
            log.error("添加分账接收方报错:",e);
        }
        return Boolean.FALSE;
    }


    public static String rsaEncryptOAEP(String message, X509Certificate certificate)
            throws IllegalBlockSizeException {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, certificate.getPublicKey());

            byte[] data = message.getBytes(StandardCharsets.UTF_8);
            byte[] cipherdata = cipher.doFinal(data);
            return Base64.getEncoder().encodeToString(cipherdata);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new RuntimeException("当前Java环境不支持RSA v1.5/OAEP", e);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException("无效的证书", e);
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            throw new IllegalBlockSizeException("加密原串的长度不能超过214字节");
        }
    }

    public void startClaimProfit(String orderId) {
        PayTransaction payTransaction = payTransactionService.getByOrderId(orderId);
        if (payTransaction == null) {
            throw new BizException("payTransaction is null");
        }
        claimProfit(payTransaction.getOrderId(),payTransaction.getAmount().intValue(),payTransaction.getDealTo(),
                payTransaction.getTransactionNo(),payTransaction.getAppId());
    }


}
