package org.dows.pay.weixin;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.binarywang.wxpay.bean.ecommerce.*;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.EcommerceService;
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
import org.dows.order.api.OrderInstanceBizApiService;
import org.dows.order.bo.OrderInstanceBo;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.request.SeparateAccountReq;
import org.dows.pay.bo.PayTransactionBo;
import org.dows.pay.bo.RelationBingBo;
import org.dows.pay.boot.PayClientConfig;
import org.dows.pay.entity.PayAccount;
import org.dows.pay.entity.PayAllocation;
import org.dows.pay.entity.PayLedgers;
import org.dows.pay.service.PayAccountService;
import org.dows.pay.service.PayAllocationService;
import org.dows.pay.service.PayLedgersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

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

    public void claimProfit(Integer amount,String transactionId,String transactionNo,String appId) {

        PayAccount payAccount = payAccountService.lambdaQuery()
                .eq(PayAccount::getChannelAccount,appId)
                .eq(PayAccount::getDeleted,0)
                .orderByDesc(PayAccount::getId)
                .last(" limit 1").one();
        if (payAccount == null) {
            log.warn("根据appId={} 查询支付账号信息为空,无法进行分账",appId);
            return;
        }
        List<SeparateAccountReq.Receivers> receivers = new ArrayList<>();
        SeparateAccountReq.Receivers  receiver = SeparateAccountReq.Receivers.builder()
                .type("MERCHANT_ID")
                .account(payAccount.getChannelMerchantNo())
                .amount(amount)
                .description("分给商户")
                .build();
        receivers.add(receiver);
        SeparateAccountReq profitSharingRequest =  SeparateAccountReq.builder()
                .receivers(receivers)
                .out_order_no(transactionNo)
                .transaction_id(transactionId)
                .appid("wx1f2863eb6cdee6a1")
                .sub_mchid(payAccount.getChannelMerchantNo())
                .unfreeze_unsplit(false)
                .finish(true)
                .build();

        try {
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
        } catch (IOException e) {
           log.error("profitSharing error:",e);
        }
    }


}
