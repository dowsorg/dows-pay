package org.dows.pay.weixin;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.cron.timingwheel.SystemTimer;
import cn.hutool.cron.timingwheel.TimerTask;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alipay.service.schema.util.StringUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.binarywang.wxpay.bean.ecommerce.*;
import com.github.binarywang.wxpay.bean.ecommerce.enums.TradeTypeEnum;
import com.github.binarywang.wxpay.bean.request.WxPayMicropayRequest;
import com.github.binarywang.wxpay.bean.result.WxPayMicropayResult;
import com.github.binarywang.wxpay.bean.result.WxPayOrderQueryResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.v3.util.RsaCryptoUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.dows.auth.biz.cache.CacheFactory;
import org.dows.auth.biz.cache.LocalCache;
import org.dows.auth.biz.context.SecurityUtils;
import org.dows.framework.api.exceptions.BizException;
import org.dows.order.api.OrderInstanceBizApiService;
import org.dows.order.bo.OrderAccountBo;
import org.dows.order.bo.OrderInstanceBo;
import org.dows.order.bo.OrderUpdatePaymentStatusBo;
import org.dows.order.enums.OrderPayTypeEnum;
import org.dows.order.form.OrderCashPayForm;
import org.dows.order.vo.OrderPayCodeVo;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.request.AccountsRequest;
import org.dows.pay.api.request.AccountsSharingRequest;
import org.dows.pay.bo.PayTransactionBo;
import org.dows.pay.boot.PayClientConfig;
import org.dows.pay.boot.PayClientFactory;
import org.dows.pay.entity.PayAccount;
import org.dows.pay.entity.PayApply;
import org.dows.pay.entity.PayLedgers;
import org.dows.pay.entity.PayTransaction;
import org.dows.pay.form.PayPartnerTransactionsQueryForm;
import org.dows.pay.form.PayTransactionForm;
import org.dows.pay.service.PayAccountService;
import org.dows.pay.service.PayApplyService;
import org.dows.pay.service.PayLedgersService;
import org.dows.pay.service.PayTransactionService;
import org.dows.store.api.StoreCouponApi;
import org.dows.store.api.StoreInstanceApi;
import org.dows.store.form.StoreCouponForm;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.IdGenerator;
import org.springframework.util.SimpleIdGenerator;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 支付相关业务功能,如：，
 * 当面付：https://open.alipay.com/api/detail?code=I1080300001000041016
 * app付款：https://open.alipay.com/api/detail?code=I1080300001000041313
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class WeixinPayHandler extends AbstractWeixinHandler {
    private final PayClientFactory payClientFactory;

    private final PayTransactionService payTransactionService;

    private final OrderInstanceBizApiService orderInstanceBizApiService;

    private final PayClientConfig payClientConfig;

    private final PayAccountService payAccountService;

    private final StoreInstanceApi storeInstanceApi;

    private final StoreCouponApi storeCouponapi;


    private final PayApplyService payApplyService;

    private final WeixinRoyaltyRelationHandler weixinRoyaltyRelationHandler;


    private final IdGenerator idGenerator = new SimpleIdGenerator();

    private static final Gson GSON = new GsonBuilder().create();


    private static final SystemTimer SYSTEMTIMER = new SystemTimer().start();

    private final PayLedgersService payLedgersService;


    private static LocalCache<String, String> ORDER_PAY_CACHE = CacheFactory.build(5L, TimeUnit.SECONDS);

    /**
     * 单笔支付
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_ORDER_PAY)
    public TransactionsResult.JsapiResult toPay(PayRequest payRequest) {
        PayTransactionBo payTransactionBo = (PayTransactionBo) payRequest.getBizModel();

        checkRepeatSubmit(payRequest.getAppId(), payTransactionBo.getOrderId());

        PayTransaction payTransaction = getPayTransaction(SecurityUtils.getMerchantNo(), payTransactionBo.getOrderId());
        if (payTransaction != null && Objects.equals(payTransaction.getStatus(), OrderPayTypeEnum.pay_finish.getCode())) {
            throw new BizException(String.format("该笔订单id:%s 已支付", payTransactionBo.getOrderId()));
        }

        if (payTransaction == null) {
            //先创建交易订单
            payTransaction = BeanUtil.copyProperties(payTransactionBo, PayTransaction.class);
            payTransaction.setPayChannel(payRequest.getChannel());
            payTransaction.setTransactionNo(DigestUtils.md5DigestAsHex(payTransactionBo.getOrderId().getBytes()));
            payTransaction.setAppId(payRequest.getAppId());
            payTransaction.setMerchantNo(SecurityUtils.getMerchantNo());
            payTransaction.setDt(new Date());
            payTransaction.setStatus(OrderPayTypeEnum.pay.getCode());
            log.info("WeixinPayHandler.toPay.payTransaction的参数:{}", payTransaction);
            payTransactionService.save(payTransaction);
        }

        //组装订单逻辑
        OrderInstanceBo orderInstanceBo = orderInstanceBizApiService.getOne(payTransactionBo.getOrderId(),true);
        PartnerTransactionsRequest.Amount amount = new PartnerTransactionsRequest.Amount();
        amount.setCurrency("CNY");
        amount.setTotal(orderInstanceBo.getAgreeAmout().multiply(new BigDecimal(100)).intValue());
        PartnerTransactionsRequest.Payer payer = new PartnerTransactionsRequest.Payer();
        payer.setSubOpenid(payRequest.getSubOpenid());
        //获取商户号
        log.info("WeixinPayHandler.toPay.orderInstanceBo的参数:{}", orderInstanceBo);
        PayAccount payAccount = payAccountService.getOne(Wrappers.lambdaQuery(PayAccount.class).eq(PayAccount::getChannelAccount, payTransactionBo.getAppId()));
        log.info("WeixinPayHandler.toPay.payAccount的参数:{}", payAccount);
        PartnerTransactionsRequest.SettleInfo settleInfo = new PartnerTransactionsRequest.SettleInfo();
        settleInfo.setProfitSharing(true);
        PartnerTransactionsRequest.SceneInfo sceneInfo = new PartnerTransactionsRequest.SceneInfo();
        sceneInfo.setPayerClientIp(payClientConfig.getClientConfigs().get(1).getIp());
        PartnerTransactionsRequest partnerTransactionsRequest = PartnerTransactionsRequest.builder()
                .spAppid("wx1f2863eb6cdee6a1")
                .spMchid("1604404392")
                .subAppid(payRequest.getAppId())
                .amount(amount)
                .subMchid(payAccount.getChannelMerchantNo())
                .description(payTransactionBo.getOrderTitle())
                .outTradeNo(payTransaction.getTransactionNo())
                .settleInfo(settleInfo)
                .notifyUrl(payClientConfig.getClientConfigs().get(1).getNotifyUrl())
                .payer(payer)
                .sceneInfo(sceneInfo)
                .build();
        log.info("WeixinPayHandler.toPay.partnerTransactionsRequest的参数:{}", GSON.toJson(partnerTransactionsRequest));
        TransactionsResult transactionsResult;
        try {
            String tradeType = TradeTypeEnum.JSAPI.getPartnerUrl();
            String url = this.getWeixinClient(payClientConfig.getClientConfigs().get(1).getAppId()).getPayBaseUrl() + tradeType;
            String response = this.getWeixinClient(payClientConfig.getClientConfigs().get(1).getAppId()).postV3(url, GSON.toJson(partnerTransactionsRequest));
            log.info("WeixinPayHandler.toPay.response的参数:{}", response);
            transactionsResult = GSON.fromJson(response, TransactionsResult.class);
        } catch (WxPayException e) {
            throw new BizException(e.getMessage());
        }
        TransactionsResult.JsapiResult jsapiResult = transactionsResult.getPayInfo
                (TradeTypeEnum.JSAPI, payTransactionBo.getAppId(),
                        payClientConfig.getClientConfigs().get(1).getMchId(),
                        this.getWeixinClient(payClientConfig.getClientConfigs().get(1).getAppId()).getConfig().getPrivateKey());
        if (!StringUtil.isEmpty(transactionsResult.getPrepayId())) {
            ORDER_PAY_CACHE.set(String.join(StringPool.UNDERSCORE, payRequest.getAppId(), payTransactionBo.getOrderId()), "success");
            log.info("调用成功");
        } else {
            //todo 失败逻辑
            PayTransaction updatePayTransaction = PayTransaction.builder()
                    .id(payTransaction.getId())
                    .status(2) //下单失败
                    .build();
            payTransactionService.updateById(updatePayTransaction);
            throw new RuntimeException("调用失败");
        }
        return jsapiResult;
    }

    @PayMapping(method = PayMethods.TRADE_ORDER_PAY)
    public String toAccounts(AccountsRequest accountsRequest) {
        //调用分账申请
        OrderInstanceBo orderInstanceBo = orderInstanceBizApiService.getOne(accountsRequest.getOrderId(),true);
        PayAccount payAccount = payAccountService.getOne(Wrappers.lambdaQuery(PayAccount.class).eq(PayAccount::getChannelAccount, accountsRequest.getAppId()));
        PayLedgers payLedger = payLedgersService.getOne(Wrappers.lambdaQuery(PayLedgers.class).eq(PayLedgers::getAppId, accountsRequest.getAppId()));
        log.info("WeixinPayHandler.toPay.payLedger的参数:{}", payLedger);
        List<AccountsSharingRequest.Receiver> receivers = new ArrayList<>();
        AccountsSharingRequest.Receiver receiver = new AccountsSharingRequest.Receiver();
        receiver.setType("MERCHANT_ID");
        receiver.setAmount(payLedger.getAllocationProfit().multiply(orderInstanceBo.getAgreeAmout().multiply(new BigDecimal(100))).intValue());
        receiver.setAccount(payLedger.getChannelAccountNo());
        receiver.setDescription("店小智");
        receivers.add(receiver);
        AccountsSharingRequest profitSharingRequest = new AccountsSharingRequest();
        profitSharingRequest.setOutOrderNo(orderInstanceBo.getOrderId());
        profitSharingRequest.setSubMchid(payAccount.getChannelMerchantNo());
        profitSharingRequest.setTransactionId(orderInstanceBo.getOrderId());
        profitSharingRequest.setAppid(accountsRequest.getAppId());
        profitSharingRequest.setFinish(false);
        profitSharingRequest.setUnfreezeUnsplit(false);
        profitSharingRequest.setReceivers(receivers);
        String url = String.format("%s/v3/ecommerce/profitsharing/orders", this.getWeixinClient(payClientConfig.getClientConfigs().get(1).getAppId()).getPayBaseUrl());
        try {
            log.info("WeixinPayHandler.toPay.profitSharingRequest的参数:{}", profitSharingRequest);
            RsaCryptoUtil.encryptFields(profitSharingRequest, this.getWeixinClient(payClientConfig.getClientConfigs().get(1).getAppId()).getConfig().getVerifier().getValidCertificate());
            String response = this.getWeixinClient(payClientConfig.getClientConfigs().get(1).getAppId()).postV3WithWechatpaySerial(url, GSON.toJson(profitSharingRequest));
            ProfitSharingResult profitSharingResult = GSON.fromJson(response, ProfitSharingResult.class);
            log.info("WeixinPayHandler.toPay.profitSharingResult的参数:{}", profitSharingResult);
            return "发起分账成功";
        } catch (WxPayException e) {
            return "发起分账失败,原因：" + e;
        }
    }

    private PayTransaction getPayTransaction(String merchantNo, String orderId) {
        return payTransactionService.getByOrderIdAndMerchantNo(merchantNo, orderId);
    }

    private void checkRepeatSubmit(String appId, String orderId) {
        String payValue = ORDER_PAY_CACHE.get(String.join(StringPool.UNDERSCORE, appId, orderId));
        if (payValue != null) {
            throw new BizException(String.format("该订单id:%s 请求支付较频繁", orderId));
        }
    }


    /**
     * 付款码支付
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_ORDER_MICROPAY_NoAcc)
    public WxPayMicropayResult micropay(PayTransactionForm payRequest) {

        String transactionNo = IdUtil.fastSimpleUUID();
        log.info("WeixinPayHandler.micropay.传入的参数:{}", GSON.toJson(payRequest));
        PayTransaction payTransaction;
        payTransaction = payTransactionService.getByOrderId(payRequest.getOrderId());
        if (payTransaction != null && Objects.equals(payTransaction.getStatus(), OrderPayTypeEnum.pay_finish.getCode())) {
            throw new BizException(String.format("该笔订单id:%s 已支付", payRequest.getOrderId()));
        }
        OrderInstanceBo preOrder = orderInstanceBizApiService.getOne(payRequest.getOrderId());
        if (preOrder == null) {
            throw new BizException("传入订单参数有误");
        }
        PayApply payApply = payApplyService.getByMerchantNoAndType(preOrder.getMerchantNo(),1);
        if(null == payApply || StrUtil.isEmpty(payApply.getAppId())){
            throw new BizException("微信支付能力为空");
        }
        String appId = payApply.getAppId();
        if (payTransaction == null) {
            //先创建交易订单
            payTransaction = BeanUtil.copyProperties(payRequest, PayTransaction.class);
            payTransaction.setPayChannel("weixin");
            payTransaction.setTransactionNo(transactionNo);
            payTransaction.setAppId(appId);
            payTransaction.setMerchantNo(SecurityUtils.getMerchantNo());
            payTransaction.setDt(new Date());
            payTransaction.setStatus(OrderPayTypeEnum.pay.getCode());
            payTransactionService.save(payTransaction);
            log.info("WeixinPayHandler.micropay.payTransaction的参数:{}", payTransaction);
        } else {
            payTransaction.setPayChannel("weixin");
            payTransaction.setAppId(appId);
            payTransaction.setTransactionNo(transactionNo);
            payTransactionService.updateById(payTransaction);
            log.info("WeixinPayHandler.micropay.payTransaction的参数:{}", payTransaction);
        }

        if(null!=payRequest.getCouponInfoList()&& CollUtil.isNotEmpty(payRequest.getCouponInfoList())) {
            OrderCashPayForm orderCashPayForm = new OrderCashPayForm();
            orderCashPayForm.setOrderId(payRequest.getOrderId());
            List<OrderCashPayForm.StoreCouponInfo> couponInfoList = BeanUtil.copyToList(payRequest.getCouponInfoList(), OrderCashPayForm.StoreCouponInfo.class);
            orderCashPayForm.setCouponInfoList(couponInfoList);
            OrderPayCodeVo orderPayCodeVo = orderInstanceBizApiService.paymentCode(orderCashPayForm);
            log.info("WeixinPayHandler.micropay calc result:{}"+GSON.toJson(orderPayCodeVo));
        }
        //组装订单逻辑
        OrderInstanceBo orderInstanceBo = orderInstanceBizApiService.getOne(payRequest.getOrderId(),true);


        try {

            WxPayMicropayRequest wxPayMicropayRequest =  WxPayMicropayRequest.newBuilder().authCode(payRequest.getAuthCode()).profitSharing("Y")
                    .totalFee(orderInstanceBo.getAgreeAmout().multiply(new BigDecimal(100)).intValue()).outTradeNo(transactionNo)
                    .body(payRequest.getOrderTitle()).spbillCreateIp(payClientConfig.getClientConfigs().get(1).getIp()).build();
            wxPayMicropayRequest.setAppid("wxcea260a244fa8559");
            wxPayMicropayRequest.setMchId("1604404392");
            wxPayMicropayRequest.setSubMchId(payRequest.getMchId());
            log.info("WeixinPayHandler.micropay.request的参数:{}", GSON.toJson(wxPayMicropayRequest));
            WxPayMicropayResult wxPayMicropayResult =  this.getWeixinClient(payClientConfig.getClientConfigs().get(1).getAppId()).micropay(wxPayMicropayRequest);

            log.info("WeixinPayHandler.micropay.response的参数:{}", GSON.toJson(wxPayMicropayResult));

            if("SUCCESS".equals(wxPayMicropayResult.getReturnCode())&&"SUCCESS".equals(wxPayMicropayResult.getResultCode())){
                log.info("支付成功");
                updateOrderStateForSucc(payRequest.getOrderId(),wxPayMicropayResult,null,SecurityUtils.getAccountId());
            }else {
                delayQueryOrder(payRequest.getOrderId(),transactionNo,1,5000L,SecurityUtils.getAccountId());
            }
            return wxPayMicropayResult;
        } catch (WxPayException e) {
            WxPayMicropayResult wxPayMicropayResult = new WxPayMicropayResult();
            wxPayMicropayResult.setResultCode(e.getResultCode());
            wxPayMicropayResult.setReturnCode(e.getReturnCode());
            wxPayMicropayResult.setReturnMsg(e.getReturnMsg());
            //throw new BizException(e.getMessage());
            log.error("WeixinPayHandler.micropay.response的参数:{}", GSON.toJson(wxPayMicropayResult));
            return wxPayMicropayResult;
        }

    }

    /**
     * 延时查询支付订单状态
     * @param orderId
     * @param delayTime
     * @throws WxPayException
     */
    private void delayQueryOrder(String orderId,String transactionNo,final int times, Long delayTime,String accountId) throws WxPayException {
        SYSTEMTIMER.addTask(new TimerTask(()->{
            try {
                WxPayOrderQueryResult wxPayOrderQueryResult =   queryOrderPayStatus(transactionNo);
                log.info("query order pay result:{}"+GSON.toJson(wxPayOrderQueryResult));
                if("USERPAYING".equals(wxPayOrderQueryResult.getTradeState())){//支付中
                    int newTimes = times + 10000;
                    if(newTimes<=5){
                        delayQueryOrder(orderId,transactionNo,newTimes,10000L,accountId);
                    }
                }
                if("SUCCESS".equals(wxPayOrderQueryResult.getTradeState())){//支付成功
                    log.info("支付成功");
                    updateOrderStateForSucc(orderId,null,wxPayOrderQueryResult,accountId);
                }

            } catch (WxPayException e) {
                e.printStackTrace();
            }
        }, delayTime));
    }

    /**
     * 支付成功更新订单信息
     * @param orderId
     * @param wxPayOrderQueryResult
     */
    private void updateOrderStateForSucc(String orderId,WxPayMicropayResult wxPayMicropayResult,WxPayOrderQueryResult wxPayOrderQueryResult,String accountId){
        PayTransaction payTransaction = payTransactionService.getByOrderId(orderId);
        ThreadUtil.execAsync(()->{
            ThreadUtil.sleep(70, TimeUnit.SECONDS);
            weixinRoyaltyRelationHandler.startClaimProfit(orderId);
        });
        if(null!=wxPayMicropayResult){
            payTransactionService.updateStatusByOrderId(wxPayMicropayResult.getTransactionId(),wxPayMicropayResult.getResultCode(),
                    orderId,OrderPayTypeEnum.pay_finish.getCode(),wxPayMicropayResult.getTotalFee());
        }
        if(null!=wxPayOrderQueryResult){
            payTransactionService.updateStatusByOrderId(wxPayOrderQueryResult.getTransactionId(),wxPayOrderQueryResult.getTradeState(),
                    orderId,OrderPayTypeEnum.pay_finish.getCode(),wxPayOrderQueryResult.getTotalFee());
        }

        try {
            OrderUpdatePaymentStatusBo instanceBo = new OrderUpdatePaymentStatusBo();
            instanceBo.setTradeStatus(3);
            instanceBo.setPayChannel(1);
            instanceBo.setTradeType(1);
            instanceBo.setOrderId(payTransaction.getOrderId());
            orderInstanceBizApiService.updateOrderInstance(instanceBo);
            OrderAccountBo accountBo = new OrderAccountBo();
            accountBo.setOrderId(payTransaction.getOrderId());
            accountBo.setPayAccountId(accountId);
            orderInstanceBizApiService.updateOrderAccountId(accountBo);
        } catch (Exception e) {
            System.out.println("invoke updateOrderInstance error:"+e);
            log.error("invoke updateOrderInstance error :",e);
        }

        //注销优惠卷
        OrderInstanceBo orderInstanceBo = orderInstanceBizApiService.getOne(payTransaction.getOrderId(),true);
        String coupon_id = orderInstanceBo.getCouponId();
        StoreCouponForm storeCouponForm = storeCouponapi.getFormByCouponId(coupon_id);
        storeCouponForm.setStatus("0");
        storeCouponapi.updateCouponForm(storeCouponForm);

    }

    /**
     * 查询订单支付状态
     * @param transactionNo
     * @return
     * @throws WxPayException
     */
    private WxPayOrderQueryResult queryOrderPayStatus(String transactionNo) throws WxPayException {
        return this.getWeixinClient(payClientConfig.getClientConfigs().get(1).getAppId()).queryOrder(null,transactionNo);
    }

    /**
     * 单笔支付无分账
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_ORDER_PAY_NoAcc)
    public TransactionsResult.JsapiResult toPayNoAcc(PayTransactionForm payRequest) {
//        PayTransactionBo payTransactionBo = (PayTransactionBo) payRequest.getBizModel();

        checkRepeatSubmit(payRequest.getAppId(), payRequest.getOrderId());
        String transactionNo = IdUtil.fastSimpleUUID();
        log.info("WeixinPayHandler.toPay.transactionNo的参数:{}", transactionNo);
        PayTransaction payTransaction;
        payTransaction = payTransactionService.getByOrderId(payRequest.getOrderId());
        if (payTransaction != null && Objects.equals(payTransaction.getStatus(), OrderPayTypeEnum.pay_finish.getCode())) {
            throw new BizException(String.format("该笔订单id:%s 已支付", payRequest.getOrderId()));
        }
        if (payTransaction == null) {
            //先创建交易订单
            payTransaction = BeanUtil.copyProperties(payRequest, PayTransaction.class);
            payTransaction.setPayChannel("weixin");
            payTransaction.setTransactionNo(transactionNo);
            payTransaction.setAppId(payRequest.getAppId());
            payTransaction.setMerchantNo(SecurityUtils.getMerchantNo());
            payTransaction.setDt(new Date());
            payTransaction.setStatus(OrderPayTypeEnum.pay.getCode());
            payTransactionService.save(payTransaction);
            log.info("WeixinPayHandler.toPay.payTransaction的参数:{}", payTransaction);
        } else {
            payTransaction.setPayChannel("weixin");
            payTransaction.setTransactionNo(transactionNo);
            payTransactionService.updateById(payTransaction);
            log.info("WeixinPayHandler.toPay.payTransaction的参数:{}", payTransaction);
        }
        //组装订单逻辑
        OrderInstanceBo orderInstanceBo = orderInstanceBizApiService.getOne(payRequest.getOrderId(),true);
        PartnerTransactionsRequest.Amount amount = new PartnerTransactionsRequest.Amount();
        amount.setCurrency("CNY");
        amount.setTotal(orderInstanceBo.getAgreeAmout().multiply(new BigDecimal(100)).intValue());
        PartnerTransactionsRequest.Payer payer = new PartnerTransactionsRequest.Payer();
        payer.setSubOpenid(payRequest.getSubOpenid());
        //获取商户号
        log.info("WeixinPayHandler.toPay.orderInstanceBo的参数:{}", orderInstanceBo);
        PayAccount payAccount = payAccountService.getOne(Wrappers.lambdaQuery(PayAccount.class).eq(PayAccount::getChannelAccount, payRequest.getAppId()));
        log.info("WeixinPayHandler.toPay.payAccount的参数:{}", payAccount);
        PartnerTransactionsRequest.SettleInfo settleInfo = new PartnerTransactionsRequest.SettleInfo();
        settleInfo.setProfitSharing(true);
        PartnerTransactionsRequest.SceneInfo sceneInfo = new PartnerTransactionsRequest.SceneInfo();
        sceneInfo.setPayerClientIp(payClientConfig.getClientConfigs().get(1).getIp());
        PartnerTransactionsRequest partnerTransactionsRequest = PartnerTransactionsRequest.builder()
                .spAppid("wx1f2863eb6cdee6a1")
                .spMchid("1604404392")
                .subAppid(payRequest.getAppId())
                .amount(amount)
                .subMchid(payAccount.getChannelMerchantNo())
                .description(payRequest.getOrderTitle())
                .outTradeNo(transactionNo)
                .settleInfo(settleInfo)
                .notifyUrl(payClientConfig.getClientConfigs().get(1).getNotifyUrl())
                .payer(payer)
                .sceneInfo(sceneInfo)
                .build();
        log.info("WeixinPayHandler.toPay.partnerTransactionsRequest的参数:{}", GSON.toJson(partnerTransactionsRequest));
        TransactionsResult transactionsResult;
        try {
            String tradeType = TradeTypeEnum.JSAPI.getPartnerUrl();
            String url = this.getWeixinClient(payClientConfig.getClientConfigs().get(1).getAppId()).getPayBaseUrl() + tradeType;
            String response = this.getWeixinClient(payClientConfig.getClientConfigs().get(1).getAppId()).postV3(url, GSON.toJson(partnerTransactionsRequest));
            log.info("WeixinPayHandler.toPay.response的参数:{}", response);
            transactionsResult = GSON.fromJson(response, TransactionsResult.class);
        } catch (WxPayException e) {
            log.error("WeixinPayHandler.toPay.error", e);
            throw new BizException(e.getMessage());
        }
        TransactionsResult.JsapiResult jsapiResult = transactionsResult.getPayInfo
                (TradeTypeEnum.JSAPI, payRequest.getAppId(),
                        payClientConfig.getClientConfigs().get(1).getMchId(),
                        this.getWeixinClient(payClientConfig.getClientConfigs().get(1).getAppId()).getConfig().getPrivateKey());
        if (!StringUtil.isEmpty(transactionsResult.getPrepayId())) {
            ORDER_PAY_CACHE.set(String.join(StringPool.UNDERSCORE, payRequest.getAppId(), payRequest.getOrderId()), "success");
            OrderAccountBo orderAccountBo = new OrderAccountBo();
            orderAccountBo.setOrderId(orderInstanceBo.getOrderId());
            orderAccountBo.setPayAccountId(SecurityUtils.getAccountId());
            orderInstanceBizApiService.updateOrderAccountId(orderAccountBo);
            log.info("调用成功");
        } else {
            //todo 失败逻辑
            PayTransaction updatePayTransaction = PayTransaction.builder()
                    .id(payTransaction.getId())
                    .status(2) //下单失败
                    .build();
            payTransactionService.updateById(updatePayTransaction);
            throw new RuntimeException("调用失败");
        }
        return jsapiResult;
    }

    /**
     * 合单支付
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_COMBINE_ORDER_PAY)
    public String toCombinePay(PayRequest payRequest) {
        //先创建交易订单
        UUID uuid = idGenerator.generateId();
        PayTransactionBo payTransactionBo = (PayTransactionBo) payRequest.getBizModel();
        PayTransaction payTransaction = BeanUtil.copyProperties(payTransactionBo, PayTransaction.class);
        payTransaction.setPayChannel(payRequest.getChannel());
        payTransaction.setTransactionNo(uuid.toString());
        payTransaction.setAppId(payRequest.getAppId());
        payTransactionService.save(payTransaction);
        CombineTransactionsRequest combineTransactionsRequest = GSON.fromJson
                (GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), CombineTransactionsRequest.class);

        TransactionsResult transactionsResult = new TransactionsResult();
        String result = "订单异常!";
        try {
            String url = this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl() + TradeTypeEnum.NATIVE.getCombineUrl();//
            String response = this.getWeixinClient(payRequest.getAppId()).postV3(url, GSON.toJson(combineTransactionsRequest));
            GSON.fromJson(response, TransactionsResult.class);
        } catch (WxPayException e) {
            throw new RuntimeException(e);
        }
        if (!StringUtil.isEmpty(transactionsResult.getPrepayId())) {
            System.out.println("调用成功");
            // todo 记录 pay_transaction表，可能有多次（失败），但只有一次是成功的
            //下单成功
            PayTransaction updatePayTransaction = PayTransaction.builder()
                    .id(payTransaction.getId())
                    .status(1) //下单成功
                    .build();
            payTransactionService.updateById(updatePayTransaction);
            result = transactionsResult.getCodeUrl();
        } else {
            //todo 失败逻辑
            PayTransaction updatePayTransaction = PayTransaction.builder()
                    .id(payTransaction.getId())
                    .status(2) //下单失败
                    .build();
            payTransactionService.updateById(updatePayTransaction);
            throw new RuntimeException("调用失败");
        }
        return result;
    }

    /**
     * 查询单笔订单
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_QUERY_ORDER)
    public PartnerTransactionsResult queryOrder(PayPartnerTransactionsQueryForm payRequest) {
        String baseUrl = this.getWeixinClient(payClientConfig.getClientConfigs().get(1).getAppId()).getPayBaseUrl();
        PayTransaction payTransaction = payTransactionService.getByOrderId(payRequest.getOutTradeNo());
        PayAccount payAccount = payAccountService.getOne(Wrappers.lambdaQuery(PayAccount.class).eq(PayAccount::getChannelAccount, payRequest.getAppId()));
//        PartnerTransactionsQueryRequest request = GSON.fromJson
//                (GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), PartnerTransactionsQueryRequest.class);
        String url = String.format("%s/v3/pay/partner/transactions/out-trade-no/%s", baseUrl, payTransaction.getTransactionNo());
        if (Objects.isNull(payRequest.getOutTradeNo())) {
            url = String.format("%s/v3/pay/partner/transactions/id/%s", baseUrl, payTransaction.getTransactionNo());
        }
        String response = "";
        try {
            String query = String.format("?sp_mchid=%s&sub_mchid=%s", "1604404392", payAccount.getChannelMerchantNo());
            response = this.getWeixinClient(payClientConfig.getClientConfigs().get(1).getAppId()).getV3(url + query);
        } catch (WxPayException e) {
            throw new RuntimeException(e);
        }
        return GSON.fromJson(response, PartnerTransactionsResult.class);
    }

    /**
     * 查询合并订单
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_COMBINE_QUERY_ORDER)
    public CombineTransactionsResult queryCombineOrder(PayRequest payRequest) {
        String baseUrl = this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl();
        CombineTransactionsRequest request = GSON.fromJson
                (GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), CombineTransactionsRequest.class);
        String url = String.format("%s/v3/combine-transactions/out-trade-no/%s", baseUrl, request.getCombineOutTradeNo());
        String response = "";
        try {
            response = this.getWeixinClient(payRequest.getAppId()).getV3(url);
        } catch (WxPayException e) {
            throw new RuntimeException(e);
        }
        return GSON.fromJson(response, CombineTransactionsResult.class);
    }

    /**
     * 关闭单笔订单
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_CLOSE_ORDER)
    public String closeOrder(PayPartnerTransactionsQueryForm payRequest) {
        PartnerTransactionsQueryRequest request = new PartnerTransactionsQueryRequest();
        PayAccount payAccount = payAccountService.getOne(Wrappers.lambdaQuery(PayAccount.class).eq(PayAccount::getChannelAccount, payRequest.getAppId()));
        String appId = payClientConfig.getClientConfigs().get(1).getAppId();
        PayTransaction payTransaction = payTransactionService.getByOrderId(payRequest.getOutTradeNo());
        request.setSpMchid("1604404392");
        request.setSubMchid(payAccount.getChannelMerchantNo());
        request.setOutTradeNo(payTransaction.getTransactionNo());
        String baseUrl = this.getWeixinClient(appId).getPayBaseUrl();
        String url = String.format("%s/v3/pay/partner/transactions/out-trade-no/%s/close", baseUrl, payTransaction.getTransactionNo());
        String response = "";
        try {
            response = this.getWeixinClient(appId).postV3(url, GSON.toJson(request));
        } catch (WxPayException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    /**
     * 关闭合并订单
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_COMBINE_CLOSE_ORDER)
    public String closeCombineOrder(PayRequest payRequest) {
        String baseUrl = this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl();
        CombineTransactionsRequest request = GSON.fromJson
                (GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), CombineTransactionsRequest.class);
        String url = String.format("%s/v3/combine-transactions/out-trade-no/%s/close", baseUrl, request.getCombineOutTradeNo());
        String reponse = "";
        try {
            reponse = this.getWeixinClient(payRequest.getAppId()).postV3(url, GSON.toJson(request));
        } catch (WxPayException e) {
            throw new RuntimeException(e);
        }
        return reponse;
    }

    /**
     * 申请退款
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_REFUNDS_ORDER)
    public RefundsResult refunds(PayRequest payRequest) {
        String baseUrl = this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl();
        String url = String.format("%s/v3/ecommerce/refunds/apply", baseUrl);
        RefundsRequest request = GSON.fromJson
                (GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), RefundsRequest.class);
        String response = "";
        try {
            response = this.getWeixinClient(payRequest.getAppId()).postV3(url, GSON.toJson(request));
        } catch (WxPayException e) {
            throw new RuntimeException(e);
        }
        return GSON.fromJson(response, RefundsResult.class);
    }

    /**
     * 申请退款查询
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_REFUNDS_QUERY_ORDER)
    public RefundQueryResult queryRefundByRefundId(PayRequest payRequest) {
        RefundsRequest request = GSON.fromJson
                (GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), RefundsRequest.class);
        String subMchid = request.getSubMchid();
        String refundId = request.getOutRefundNo();
        String baseUrl = this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl();
        String url = String.format("%s/v3/ecommerce/refunds/id/%s?sub_mchid=%s", baseUrl, refundId, subMchid);
        String response = "";
        try {
            response = this.getWeixinClient(payRequest.getAppId()).getV3(url);
        } catch (WxPayException e) {
            throw new RuntimeException(e);
        }
        return GSON.fromJson(response, RefundQueryResult.class);
    }

    /**
     * 二级商户提现申请
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_SUB_WITHDRAW_APPLY)
    public SubWithdrawResult subWithdraw(PayRequest payRequest) {
        SubWithdrawRequest request = GSON.fromJson
                (GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), SubWithdrawRequest.class);
        String url = String.format("%s/v3/ecommerce/fund/withdraw", this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl());
        String response = "";
        try {
            response = this.getWeixinClient(payRequest.getAppId()).postV3(url, GSON.toJson(request));
        } catch (WxPayException e) {
            throw new RuntimeException(e);
        }
        return GSON.fromJson(response, SubWithdrawResult.class);
    }

    /**
     * 二级商户提现查询
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_SUB_WITHDRAW_QUERY_APPLY)
    public SubWithdrawStatusResult querySubWithdrawByOutRequestNo(PayRequest payRequest) {
        SubWithdrawRequest request = GSON.fromJson
                (GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), SubWithdrawRequest.class);
        String subMchid = request.getSubMchid();
        String outRequestNo = request.getOutRequestNo();
        String url = String.format("%s/v3/ecommerce/fund/withdraw/out-request-no/%s?sub_mchid=%s", this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl(), outRequestNo, subMchid);
        String response = "";
        try {
            response = this.getWeixinClient(payRequest.getAppId()).getV3(url);
        } catch (WxPayException e) {
            throw new RuntimeException(e);
        }
        return GSON.fromJson(response, SubWithdrawStatusResult.class);
    }

    /**
     * 平台提现申请
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_SP_WITHDRAW_APPLY)
    public SpWithdrawResult spWithdraw(PayRequest payRequest) {
        SpWithdrawRequest request = GSON.fromJson
                (GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), SpWithdrawRequest.class);
        String url = String.format("%s/v3/merchant/fund/withdraw", this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl());
        String response = "";
        try {
            response = this.getWeixinClient(payRequest.getAppId()).postV3(url, GSON.toJson(request));
        } catch (WxPayException e) {
            throw new RuntimeException(e);
        }
        return GSON.fromJson(response, SpWithdrawResult.class);
    }

    public Map<String, Object> queryWechatOrder(String transactionNo, String appId) {
        LambdaQueryWrapper<PayApply> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(PayApply::getAppId, appId);
        queryWrapper.eq(PayApply::getApplyType, 1);
        PayApply payApply = payApplyService.getOne(queryWrapper);

        CloseableHttpClient httpClient = this.getWeixinClient(payClientConfig.getClientConfigs().get(1)
                .getAppId()).getConfig().getApiV3HttpClient();

        HttpGet httpGet = new HttpGet("https://api.mch.weixin.qq.com/v3/pay/partner/transactions/out-trade-no/" + transactionNo +
                "?sp_mchid=1604404392&sub_mchid=" + payApply.getSubMchid());
        httpGet.setHeader("Accept", "application/json");
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            log.info("success,return body = {}", EntityUtils.toString(response.getEntity()));
            String responseStr = EntityUtils.toString(response.getEntity());
            Map<String, Object> map = JSONUtil.toBean(responseStr, Map.class);
            log.info("wechatQuery map is {}", JSON.toJSONString(map));
            return map;
        } catch (Exception e) {
            log.error("queryWechatOrder fail:", e);
            return new HashMap<>();
        }
    }


    /**
     * 平台提现申请查询
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_SP_WITHDRAW_QUERY_APPLY)
    public SpWithdrawStatusResult querySpWithdrawByOutRequestNo(PayRequest payRequest) {
        SpWithdrawRequest request = GSON.fromJson
                (GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), SpWithdrawRequest.class);
        String outRequestNo = request.getOutRequestNo();
        String url = String.format("%s/v3/merchant/fund/withdraw/out-request-no/%s", this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl(), outRequestNo);
        String response = "";
        try {
            response = this.getWeixinClient(payRequest.getAppId()).getV3(url);
        } catch (WxPayException e) {
            throw new RuntimeException(e);
        }
        return GSON.fromJson(response, SpWithdrawStatusResult.class);
    }

}
