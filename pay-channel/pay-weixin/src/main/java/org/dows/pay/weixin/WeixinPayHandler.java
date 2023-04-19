package org.dows.pay.weixin;

import cn.hutool.core.bean.BeanUtil;
import com.alipay.service.schema.util.StringUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.binarywang.wxpay.bean.ecommerce.*;
import com.github.binarywang.wxpay.bean.ecommerce.enums.TradeTypeEnum;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.v3.util.RsaCryptoUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.order.api.OrderInstanceBizApiService;
import org.dows.order.bo.OrderInstanceBo;
import org.dows.order.entity.OrderInstance;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.bo.PayTransactionBo;
import org.dows.pay.boot.PayClientConfig;
import org.dows.pay.boot.PayClientFactory;
import org.dows.pay.entity.PayAccount;
import org.dows.pay.entity.PayLedgers;
import org.dows.pay.entity.PayTransaction;
import org.dows.pay.service.PayAccountService;
import org.dows.pay.service.PayLedgersService;
import org.dows.pay.service.PayTransactionService;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;
import org.springframework.util.SimpleIdGenerator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

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

    private final IdGenerator idGenerator = new SimpleIdGenerator();

    private static final Gson GSON = new GsonBuilder().create();

    private final PayLedgersService payLedgersService;

    /**
     * 单笔支付
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_ORDER_PAY)
    public String toPay(PayRequest payRequest) {
        //先创建交易订单
        UUID uuid = idGenerator.generateId();
        PayTransactionBo payTransactionBo = (PayTransactionBo)payRequest.getBizModel();
        PayTransaction payTransaction = BeanUtil.copyProperties(payTransactionBo, PayTransaction.class);
        payTransaction.setPayChannel(payRequest.getChannel());
        payTransaction.setTransactionNo(uuid.toString());
        payTransaction.setAppId(payRequest.getAppId());
        payTransactionService.save(payTransaction);
        //组装订单逻辑
        OrderInstanceBo orderInstanceBo = orderInstanceBizApiService.getOne(payTransactionBo.getOrderId());
        PartnerTransactionsRequest.Amount amount =  new PartnerTransactionsRequest.Amount();
        amount.setCurrency("CNY");
        amount.setTotal(orderInstanceBo.getAgreeAmout().multiply(new BigDecimal(100)).intValue());
        PartnerTransactionsRequest.Payer payer = new PartnerTransactionsRequest.Payer();
        payer.setSubOpenid(payTransactionBo.getSubOpenid());
        //获取商户号
        PayAccount payAccount = payAccountService.getOne(Wrappers.lambdaQuery(PayAccount.class).eq(PayAccount::getChannelAccount, orderInstanceBo.getAppId()));
        PartnerTransactionsRequest.SettleInfo settleInfo = new PartnerTransactionsRequest.SettleInfo();
        settleInfo.setProfitSharing(true);
        PartnerTransactionsRequest partnerTransactionsRequest = PartnerTransactionsRequest.builder()
                .spAppid(payRequest.getAppId())
                .spMchid(this.getWeixinClient(payRequest.getAppId()).getConfig().getMchId())
                .amount(amount)
                .subAppid(orderInstanceBo.getAppId())
                .subMchid(payAccount.getChannelMerchantNo())
                .description(payTransactionBo.getOrderTitle())
                .outTradeNo(orderInstanceBo.getOrderId())
                .settleInfo(settleInfo)
                .notifyUrl(payClientConfig.getClientConfigs().get(0).getNotifyUrl())
                .payer(payer)
                .build();

        String result = "下单异常!";
        TransactionsResult transactionsResult = new TransactionsResult();
        try {
            String tradeType = TradeTypeEnum.JSAPI.getPartnerUrl();
            if("APP".equals(payTransactionBo.getTradeType())){
                tradeType = TradeTypeEnum.APP.getPartnerUrl();
            }else if("NATIVE".equals(payTransactionBo.getTradeType())){
                tradeType = TradeTypeEnum.NATIVE.getPartnerUrl();
            }else{
                tradeType = TradeTypeEnum.MWEB.getPartnerUrl();
            }
            String url = this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl()+tradeType ;
            String response = this.getWeixinClient(payRequest.getAppId()).postV3(url, GSON.toJson(partnerTransactionsRequest));
            GSON.fromJson(response, TransactionsResult.class);
        } catch ( WxPayException e) {
            throw new RuntimeException(e);
        }
        if (!StringUtil.isEmpty(transactionsResult.getPrepayId())){
            System.out.println("调用成功");
            // todo 记录 pay_transaction表，可能有多次（失败），但只有一次是成功的
            //下单成功
            PayTransaction updatePayTransaction = PayTransaction.builder()
                    .id(payTransaction.getId())
                    .status(1) //下单成功
                    .build();
            payTransactionService.updateById(updatePayTransaction);
            //调用分账申请
            PayLedgers payLedger = payLedgersService.getOne(Wrappers.lambdaQuery(PayLedgers.class).eq(PayLedgers::getAppId, orderInstanceBo.getAppId()));
            List<ProfitSharingRequest.Receiver> receivers = new ArrayList<>();
            ProfitSharingRequest.Receiver  receiver = new ProfitSharingRequest.Receiver();
            receiver.setType("MERCHANT_ID");
            receiver.setAmount(payLedger.getAllocationProfit().multiply(orderInstanceBo.getAgreeAmout().multiply(new BigDecimal(100))).intValue());
            receiver.setReceiverAccount(payLedger.getChannelAccountNo());
            receivers.add(receiver);
            ProfitSharingRequest profitSharingRequest = new ProfitSharingRequest();
            profitSharingRequest.setOutOrderNo(orderInstanceBo.getOrderId());
            profitSharingRequest.setSubMchid(payAccount.getChannelMerchantNo());
            profitSharingRequest.setTransactionId(orderInstanceBo.getOrderId());
            profitSharingRequest.setAppid(payRequest.getAppId());
            profitSharingRequest.setFinish(false);
            profitSharingRequest.setReceivers(receivers);
            String url = String.format("%s/v3/ecommerce/profitsharing/orders", this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl());
            try {
                RsaCryptoUtil.encryptFields(profitSharingRequest, this.getWeixinClient(payRequest.getAppId()).getConfig().getVerifier().getValidCertificate());
                String response = this.getWeixinClient(payRequest.getAppId()).postV3WithWechatpaySerial(url, GSON.toJson(profitSharingRequest));
                ProfitSharingResult profitSharingResult = GSON.fromJson(response, ProfitSharingResult.class);
            } catch (WxPayException e) {
                throw new RuntimeException(e);
            }
            result =  transactionsResult.getCodeUrl();
        } else {
            //todo 失败逻辑
            PayTransaction updatePayTransaction = PayTransaction.builder()
                    .id(payTransaction.getId())
                    .status(2) //下单失败
                    .build();
            payTransactionService.updateById(updatePayTransaction);
            throw new RuntimeException("调用失败");
        }
        return  result;
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
        PayTransactionBo payTransactionBo = (PayTransactionBo)payRequest.getBizModel();
        PayTransaction payTransaction = BeanUtil.copyProperties(payTransactionBo, PayTransaction.class);
        payTransaction.setPayChannel(payRequest.getChannel());
        payTransaction.setTransactionNo(uuid.toString());
        payTransaction.setAppId(payRequest.getAppId());
        payTransactionService.save(payTransaction);
        CombineTransactionsRequest combineTransactionsRequest =  GSON.fromJson
                (GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), CombineTransactionsRequest.class);

        TransactionsResult transactionsResult = new TransactionsResult();
        String result = "订单异常!";
        try {
            String url = this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl()+ TradeTypeEnum.NATIVE.getCombineUrl();//
            String response = this.getWeixinClient(payRequest.getAppId()).postV3(url, GSON.toJson(combineTransactionsRequest));
            GSON.fromJson(response, TransactionsResult.class);
        } catch ( WxPayException e) {
            throw new RuntimeException(e);
        }
        if (!StringUtil.isEmpty(transactionsResult.getPrepayId())){
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
    public PartnerTransactionsResult queryOrder(PayRequest payRequest) {
        String baseUrl = this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl();
        PartnerTransactionsQueryRequest request = GSON.fromJson
                (GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), PartnerTransactionsQueryRequest.class);
        String url = String.format("%s/v3/pay/partner/transactions/out-trade-no/%s", baseUrl, request.getOutTradeNo());
        if (Objects.isNull(request.getOutTradeNo())) {
            url = String.format("%s/v3/pay/partner/transactions/id/%s", baseUrl, request.getTransactionId());
        }
        String response="";
        try{
            String query = String.format("?sp_mchid=%s&sub_mchid=%s", request.getSpMchid(), request.getSubMchid());
            response = this.getWeixinClient(payRequest.getAppId()).getV3(url + query);
        }catch (WxPayException e){
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
        try{
            response = this.getWeixinClient(payRequest.getAppId()).getV3(url);
        }catch (WxPayException e){
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
    public String closeOrder(PayRequest payRequest) {
        PartnerTransactionsQueryRequest request = GSON.fromJson
                (GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), PartnerTransactionsQueryRequest.class);
        String baseUrl = this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl();
        String url = String.format("%s/v3/pay/partner/transactions/out-trade-no/%s/close", baseUrl, request.getOutTradeNo());
        String response ="";
        try{
            response = this.getWeixinClient(payRequest.getAppId()).postV3(url, GSON.toJson(request));
        }catch (WxPayException e){
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
        try{
        reponse = this.getWeixinClient(payRequest.getAppId()).postV3(url, GSON.toJson(request));
        }catch (WxPayException e){
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
    public RefundsResult refunds(PayRequest payRequest){
        String baseUrl = this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl();
        String url = String.format("%s/v3/ecommerce/refunds/apply", baseUrl);
        RefundsRequest request = GSON.fromJson
                (GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), RefundsRequest.class);
        String response = "";
        try{
            response =  this.getWeixinClient(payRequest.getAppId()).postV3(url, GSON.toJson(request));
        }catch (WxPayException e){
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
        try{
            response = this.getWeixinClient(payRequest.getAppId()).getV3(url);
        }catch (WxPayException e){
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
    public SubWithdrawResult subWithdraw(PayRequest payRequest){
        SubWithdrawRequest request = GSON.fromJson
                (GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), SubWithdrawRequest.class);
        String url = String.format("%s/v3/ecommerce/fund/withdraw", this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl());
        String response = "";
        try{
        response = this.getWeixinClient(payRequest.getAppId()).postV3(url, GSON.toJson(request));
        }catch (WxPayException e){
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
    public SubWithdrawStatusResult querySubWithdrawByOutRequestNo(PayRequest payRequest){
        SubWithdrawRequest request = GSON.fromJson
                (GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), SubWithdrawRequest.class);
        String subMchid = request.getSubMchid();
        String outRequestNo = request.getOutRequestNo();
        String url = String.format("%s/v3/ecommerce/fund/withdraw/out-request-no/%s?sub_mchid=%s", this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl(), outRequestNo, subMchid);
        String response ="";
        try{
            response = this.getWeixinClient(payRequest.getAppId()).getV3(url);
        }catch (WxPayException e){
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
        try{
        response =this.getWeixinClient(payRequest.getAppId()).postV3(url, GSON.toJson(request));
        }catch (WxPayException e){
            throw new RuntimeException(e);
        }
        return GSON.fromJson(response, SpWithdrawResult.class);
    }

    /**
     * 平台提现申请查询
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_SP_WITHDRAW_QUERY_APPLY)
    public SpWithdrawStatusResult querySpWithdrawByOutRequestNo(PayRequest payRequest)  {
        SpWithdrawRequest request = GSON.fromJson
                (GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), SpWithdrawRequest.class);
        String outRequestNo = request.getOutRequestNo();
        String url = String.format("%s/v3/merchant/fund/withdraw/out-request-no/%s",this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl(), outRequestNo);
        String response = "";
        try{
            response = this.getWeixinClient(payRequest.getAppId()).getV3(url);
        }catch (WxPayException e){
            throw new RuntimeException(e);
        }
        return GSON.fromJson(response, SpWithdrawStatusResult.class);
    }

}
