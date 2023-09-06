package org.dows.pay.alipay;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.msg.AlipayMsgClient;
import com.alipay.api.request.*;
import com.alipay.api.response.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.account.api.AccountInstanceApi;
import org.dows.account.vo.AccountInstanceVo;
import org.dows.auth.api.TempRedisApi;
import org.dows.auth.biz.context.SecurityUtils;
import org.dows.auth.entity.TempRedis;
import org.dows.framework.api.exceptions.BizException;
import org.dows.framework.oss.api.OssInfo;
import org.dows.framework.oss.tencent.TencentOssClient;
import org.dows.order.api.OrderInstanceBizApiService;
import org.dows.order.bo.OrderInstanceBo;
import org.dows.pay.api.PayEvent;
import org.dows.pay.api.PayException;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.event.OrderPaySuccessEvent;
import org.dows.pay.api.message.AlipayMessage;
import org.dows.pay.api.request.ScanPayApplyRes;
import org.dows.pay.api.response.PayQueryRes;
import org.dows.pay.boot.PayClientFactory;
import org.dows.pay.boot.properties.PayClientProperties;
import org.dows.pay.entity.PayAccount;
import org.dows.pay.entity.PayLedgers;
import org.dows.pay.entity.PayLedgersRecord;
import org.dows.pay.entity.PayTransaction;
import org.dows.pay.form.AliPayRequest;
import org.dows.pay.mapper.PayLedgersRecordMapper;
import org.dows.pay.service.PayAccountService;
import org.dows.pay.service.PayLedgersService;
import org.dows.pay.service.PayTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;
import org.springframework.util.SimpleIdGenerator;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * 支付相关业务功能,如：，
 * 当面付：https://open.alipay.com/api/detail?code=I1080300001000041016
 * app付款：https://open.alipay.com/api/detail?code=I1080300001000041313
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class AlipayPayHandler extends AbstractAlipayHandler {
    private final PayClientFactory payClientFactory;

    private final PayTransactionService payTransactionService;

    private final PayLedgersRecordMapper payLedgersRecordMapper;

    private final PayAccountService payAccountService;

    @Lazy
    @Autowired
    private TencentOssClient localOssClient;

    private final PayLedgersService payLedgersService;

    private static final String ALI_PAY_NOTIFY_URL = "https://www.dxzsaas.com/api/user/aliPay/notify";

    private final IdGenerator idGenerator = new SimpleIdGenerator();

    private final AccountInstanceApi accountInstanceApi;

    private final TempRedisApi tempRedisApi;

    private final OrderInstanceBizApiService orderInstanceBizApiService;

    /**
     * 去支付
     */
    @PayMapping(method = PayMethods.TRADE_ORDER_PAY)
    public AlipayTradeCreateResponse toPay(AliPayRequest payTransactionBo) {
        PayTransaction payTransaction = payTransactionService.getByOrderId(payTransactionBo.getOrderId());
        if (payTransaction == null) {
            payTransaction = new PayTransaction();
        }
        if (Objects.equals(payTransaction.getStatus(), 1)) {
            throw new BizException("该订单已支付,请勿重复发起");
        }
        OrderInstanceBo orderInstanceBo = orderInstanceBizApiService.getOne(payTransactionBo.getOrderId());
        if (orderInstanceBo == null) {
            throw new BizException("传入订单参数有误");
        }
        String accountId = orderInstanceBo.getAccountId();
        if (StrUtil.isEmpty(accountId)) {
            throw new BizException("订单记录用户账号字段为空");
        }
        AccountInstanceVo accountInstanceVo = accountInstanceApi.selectAccountInstanceByAccountId(accountId);
        if (Objects.isNull(accountInstanceVo)) {
            throw new BizException("用户账号查询为空 accountId=:" + accountId);
        }
        String appId = orderInstanceBo.getAppId();
        TempRedis tempRedis = tempRedisApi.getKey(appId);
        if (Objects.isNull(tempRedis)) {
            throw new BizException("获取商家授权token为空,appId=" + appId);
        }
        //先创建交易订单
        UUID uuid = idGenerator.generateId();
        payTransaction.setPayChannel("aliPay");
        payTransaction.setTransactionNo(uuid.toString());
        payTransaction.setAppId(orderInstanceBo.getAppId());
        payTransaction.setMerchantNo(SecurityUtils.getMerchantNo());
        if (payTransaction.getId() == null) {
            payTransactionService.save(payTransaction);
        }

        AlipayTradeCreateRequest request = new AlipayTradeCreateRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", uuid);
        bizContent.put("total_amount", orderInstanceBo.getAgreeAmout());
        bizContent.put("subject", "支付宝下单");
        bizContent.put("timeout_express", "10m");
//        bizContent.put("buyer_id",accountInstanceVo.getUserId());
        // 商户实际经营主体的小程序应用的appid
        bizContent.put("op_app_id", orderInstanceBo.getAppId());
//        bizContent.put("product_code", "JSAPI_PAY");
        bizContent.put("product_code", "FACE_TO_FACE_PAYMENT");
        request.setNotifyUrl(ALI_PAY_NOTIFY_URL);
        request.setBizContent(bizContent.toString());
        AlipayTradeCreateResponse response;
        try {
            // appId="2021004100609101"   token="202307BB6204a0ec6a3c4f7ebf83e7c993cc6X96"
            response = getAlipayClient("2021003129694075").certificateExecute(request, null, tempRedis.getRvalue());
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
        if (response.isSuccess()) {
            //下单成功
            PayTransaction updatePayTransaction = PayTransaction.builder()
                    .id(payTransaction.getId())
                    .dealTo(response.getTradeNo())
                    .build();
            payTransactionService.updateById(updatePayTransaction);
        } else {
            PayTransaction updatePayTransaction = PayTransaction.builder()
                    .id(payTransaction.getId())
                    .status(2)
                    .remark(String.join(",", response.getMsg(), response.getSubMsg()))
                    .build();
            payTransactionService.updateById(updatePayTransaction);
            throw new BizException("支付宝创建订单失败:" + response.getSubMsg());
        }
        return response;
    }


    /**
     * todo 用户支付成功回调，内部数据处理逻辑
     *
     * @param request
     * @return
     * @throws IOException
     */
    /**
     * 支付结果通知
     */
    @EventListener(value = {PayEvent.class})
    public void onPaySuccessEvent(PayEvent<AlipayMessage> payEvent) throws AlipayApiException, PayException, InterruptedException {
        log.info("aliPay onPaySuccessEvent :{}", JSON.toJSONString(payEvent));
        // 获取回调事件对应的应用ID
        String appId = payEvent.getPayMessage().getAppId();
        // 根据应用ID获取消息客户端
        AlipayMsgClient alipayMsgClient = payClientFactory.getAlipayMsgClient(appId);
        if (alipayMsgClient == null) {
            throw new PayException("应用ID:" + appId + "没有配置消息客户端");
        }

        Map<String, String> params = new HashMap<String, String>();
        //获取支付宝POST过来反馈信息
        String bizContent = payEvent.getPayMessage().getBizContent();
        Map<String, String[]> requestParams = JSON.parseObject(bizContent, Map.class);
        log.error("支付宝回调开始 request{}: " + JSON.toJSONString(requestParams));
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        //获取订单号
        String outTradeNo = params.get("out_trade_no");
        //String orderCode = new String(outTradeNo.getBytes("ISO-8859-1"), "UTF-8");
        LambdaQueryChainWrapper<PayTransaction> payTransactionWrapper = payTransactionService.lambdaQuery()
                .eq(PayTransaction::getTransactionNo, outTradeNo);
        PayTransaction payTransaction = payTransactionService.getOne(payTransactionWrapper);
        //支付成功或者失败 都告诉支付success
        if (payTransaction.getStatus().equals(3) || payTransaction.getStatus().equals(4)) {

            // 创建具体返回消息体
            AlipayRequest alipayRequest = null;
            alipayMsgClient.sendMessage(alipayRequest);
        }
        //获取key
        //调用SDK验证签名
        PayClientProperties payClientProperties = payClientFactory.getPayClientProperties(appId);
        if (payClientProperties != null) {
            String payCertPath = payClientProperties.getAliPayCertPath();
            boolean signVerified = AlipaySignature.rsaCertCheckV1(params, payCertPath, "utf-8", "RSA2");
            //验证成功
            if (!signVerified) {
                log.error("###支付宝支付回调校验失败####");
                // 创建具体返回消息体
                AlipayRequest alipayRequest = null;
                alipayMsgClient.sendMessage(alipayRequest);
            }
            //修改订单状态
            //支付宝交易号
            log.error("支付宝回调更新状态参数:{}" + JSON.toJSONString(params));
            String tradeStatus = params.get("trade_status");
            // todo payTransaction 少外部订单号
            if ("TRADE_SUCCESS".equals(tradeStatus)) {
                payTransaction.setStatus(1);
            } else {
                payTransaction.setStatus(4);
            }
            payTransaction.setTransactionTime(new Date());
            payTransactionService.updateById(payTransaction);
            if (!params.get("trade_status").equals("TRADE_SUCCESS")) {//TRADE_CLOSED
                // return "success";
                AlipayRequest alipayRequest = null;
                alipayMsgClient.sendMessage(alipayRequest);
            }
            // todo 是否需要作记录log？
            OrderPaySuccessEvent orderPaySuccessEvent = new OrderPaySuccessEvent(null, outTradeNo, "alipay", new Date(), new Date());
            applicationEventPublisher.publishEvent(orderPaySuccessEvent);
            AlipayRequest alipayRequest = null;
            alipayMsgClient.sendMessage(alipayRequest);
        }
        AlipayRequest alipayRequest = null;
        alipayMsgClient.sendMessage(alipayRequest);
    }

    public PayQueryRes queryPayStatus(PayTransaction payTransaction) {
        TempRedis tempRedis = tempRedisApi.getKey(payTransaction.getAppId());
        if (Objects.isNull(tempRedis)) {
            throw new BizException("获取商家授权token为空,appId=" + payTransaction.getAppId());
        }
        AlipayTradeQueryRequest req = new AlipayTradeQueryRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", payTransaction.getTransactionNo());
        req.setBizContent(bizContent.toString());
        AlipayTradeQueryResponse response;
        try {
            response = getAlipayClient("2021003129694075").certificateExecute(req, null, tempRedis.getRvalue());
            if (response.getSendPayDate() != null) {
                payTransaction.setDealTo(response.getTradeNo());
                ThreadUtil.execAsync(()->readyClaimProfit(tempRedis.getRvalue(), payTransaction));
                return PayQueryRes.builder()
                        .payDesc(response.getTradeStatus())
                        .outTradeNo(response.getTradeNo())
                        .payAmount(new BigDecimal(response.getBuyerPayAmount()).multiply(new BigDecimal("100")))
                        .payTime(response.getSendPayDate()).build();
            }
            return PayQueryRes.builder().build();
        } catch (AlipayApiException e) {
            log.error("queryPayStatus fail:", e);
            throw new BizException("查询订单失败:" + e.getMessage());
        }

    }

    public void readyClaimProfit(String token, PayTransaction payTransaction) {

        bindRelation("2088131534177640", "userId", payTransaction.getAppId(), payTransaction.getMerchantNo(), token);
        orderSettle(payTransaction.getMerchantNo(), payTransaction.getAppId(), token, payTransaction.getDealTo(),
                payTransaction.getOrderId());
    }


    public void orderSettle(String merchantNo, String appId, String token, String tradeNo, String orderId) {

        if (new LambdaQueryChainWrapper<>(payLedgersRecordMapper)
                .eq(PayLedgersRecord::getOrderId, orderId)
                .eq(PayLedgersRecord::getState,1).count()>0) {
            return;
        }

        OrderInstanceBo orderInstanceBo = orderInstanceBizApiService.getOne(orderId, true);
        if (orderInstanceBo == null) {
            log.error("orderId={} 查询订单信息为空", orderId);
            throw new BizException("订单信息为空");
        }
        PayAccount payAccount = payAccountService.lambdaQuery()
                .eq(PayAccount::getChannelAccount, appId)
                .eq(PayAccount::getDeleted, 0)
                .orderByDesc(PayAccount::getId)
                .last(" limit 1").one();
        if (payAccount == null) {
            log.error("通过appId={} 查询支付账号信息为空,无法进行分账", appId);
            return;
        }
        // 暂定20%比例
        BigDecimal separateAmount = orderInstanceBo.getAgreeAmout().multiply(new BigDecimal(20))
         .divide(new BigDecimal("100"),2, RoundingMode.CEILING);
        String receiveUserId = "2088131534177640";
        String requestNo = IdUtil.fastSimpleUUID();
        AlipayTradeOrderSettleRequest request = new AlipayTradeOrderSettleRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_request_no", requestNo);
        bizContent.put("trade_no", tradeNo);

        JSONArray jsonArray = new JSONArray();
        JSONObject settleDetail = new JSONObject();
        settleDetail.put("trans_out", payAccount.getChannelMerchantNo());
        settleDetail.put("trans_out_type", "userId");
        settleDetail.put("trans_in_type", "userId");
        settleDetail.put("trans_in", receiveUserId);
        settleDetail.put("amount", separateAmount);
        settleDetail.put("desc", String.format("分账给 %s", "2088131534177640"));
        jsonArray.add(settleDetail);
        bizContent.put("royalty_parameters", jsonArray);
        request.setBizContent(bizContent.toString());
        AlipayTradeOrderSettleResponse response;
        PayLedgersRecord payLedgersRecord = buildPayLedgerRecord(orderId, merchantNo, appId, receiveUserId,
                payAccount.getChannelMerchantNo(), separateAmount.multiply(new BigDecimal("100")), 20);
        try {
            log.info("ali orderSettle req is {}", bizContent);
            response = getAlipayClient("2021003129694075").certificateExecute(request, null, token);
            log.info("orderSettle res is:{}", JSON.toJSONString(response));
            payLedgersRecord.setResult(JSON.toJSONString(response));
            if (response.isSuccess()) {
                payLedgersRecord.setState(1);
            }
            payLedgersRecordMapper.updateById(payLedgersRecord);
        } catch (AlipayApiException e) {
            log.error("orderSettle fail:", e);
        }
    }

    private PayLedgersRecord buildPayLedgerRecord(String orderId, String merchantNo, String appId, String receiveUserId,
                                                  String transOut, BigDecimal amount, Integer ratio) {
        PayLedgersRecord payLedgersRecord = new PayLedgersRecord();
        payLedgersRecord.setOrderId(orderId);
        payLedgersRecord.setMerchantNo(merchantNo);
        payLedgersRecord.setAppId("2021003129694075");
        payLedgersRecord.setAccountId(receiveUserId);
        payLedgersRecord.setChannelCode("aliPay");
        payLedgersRecord.setAccountName("上海有星科技有限公司");
        payLedgersRecord.setChannelAppId(appId);
        payLedgersRecord.setChannelAccountNo(transOut);
        payLedgersRecord.setChannelAccountType(true);
        payLedgersRecord.setAllocationProfit(new BigDecimal(ratio));
        payLedgersRecord.setAmount(amount);
        payLedgersRecord.setCreateTime(new Date());
        payLedgersRecordMapper.insert(payLedgersRecord);
        return payLedgersRecord;
    }


    public Boolean bindRelation(String account, String type, String appId, String merchantNo, String token) {

        PayLedgers payLedgers = payLedgersService.lambdaQuery()
                .eq(PayLedgers::getAppId, "2021003129694075")
                .eq(PayLedgers::getChannelAppId, appId)
                .orderByDesc(PayLedgers::getId).one();

        if (Objects.isNull(payLedgers)) {
            if (Objects.isNull(token)) {
                TempRedis tempRedis = tempRedisApi.getKey(appId);
                if (Objects.isNull(tempRedis)) {
                    throw new BizException("获取商家授权token为空,appId=" + appId);
                }
                token = tempRedis.getRvalue();
            }

            String requestNo = IdUtil.fastSimpleUUID();

            AlipayTradeRoyaltyRelationBindRequest request = new AlipayTradeRoyaltyRelationBindRequest();
            JSONObject receiveJson = new JSONObject();
            receiveJson.put("type", type);
            receiveJson.put("account", account);
            receiveJson.put("memo", "分账给服务商");
            receiveJson.put("out_request_no", IdUtil.fastSimpleUUID());

            JSONArray jsonArray = new JSONArray();
            jsonArray.add(receiveJson);

            JSONObject bizContent = new JSONObject();
            bizContent.put("out_request_no", IdUtil.fastSimpleUUID());
            bizContent.put("receiver_list",jsonArray);
            request.setBizContent(bizContent.toString());
            AlipayTradeRoyaltyRelationBindResponse response;

            log.info("bindRelation req is {}", bizContent);
            try {
                response = getAlipayClient("2021003129694075").certificateExecute(request, null, token);
                if (response.isSuccess()) {
                    payLedgers = new PayLedgers();
                    payLedgers.setMerchantNo(merchantNo);
                    payLedgers.setAppId("2021003129694075");
                    payLedgers.setAccountId(account);
                    payLedgers.setAccountName("上海有星科技有限公司");
                    payLedgers.setChannelId(requestNo);
                    payLedgers.setChannelCode("aliPay");
                    payLedgers.setChannelAppId(appId);
                    payLedgers.setState(true);
                    payLedgers.setAllocationProfit(new BigDecimal(20));
                    payLedgers.setCreateTime(new Date());
                    payLedgersService.save(payLedgers);
                }
            } catch (AlipayApiException e) {
                log.error("bindRelation req fail:", e);
                throw new BizException("支付宝绑定分账关系报错:" + e.getMessage());
            }
        }
        return Boolean.TRUE;
    }


    public ScanPayApplyRes scanPay(AliPayRequest payTransactionBo) {

        PayTransaction payTransaction = payTransactionService.getByOrderId(payTransactionBo.getOrderId());
        if (payTransaction == null) {
            payTransaction = new PayTransaction();
        }
        if (Objects.equals(payTransaction.getStatus(), 1)) {
            throw new BizException("该订单已支付,请勿重复发起");
        }
        if (payTransactionBo.getAmount() == null) {
            OrderInstanceBo orderInstanceBo = orderInstanceBizApiService.getOne(payTransactionBo.getOrderId());
            if (orderInstanceBo == null) {
                throw new BizException("传入订单参数有误");
            }
            payTransactionBo.setAmount(orderInstanceBo.getAgreeAmout());
            payTransactionBo.setAppId(orderInstanceBo.getAppId());
            payTransactionBo.setMerchantNo(SecurityUtils.getMerchantNo());
        }

        TempRedis tempRedis = tempRedisApi.getKey(payTransactionBo.getAppId());
        if (Objects.isNull(tempRedis)) {
            throw new BizException("获取商家授权token为空,appId=" + payTransactionBo.getAppId());
        }
        //先创建交易订单
        String uuid = IdUtil.fastSimpleUUID();
        payTransaction.setOrderId(payTransactionBo.getOrderId());
        payTransaction.setPayChannel("aliPay");
        payTransaction.setTransactionNo(uuid);
        payTransaction.setAppId(payTransactionBo.getAppId());
        payTransaction.setMerchantNo(payTransactionBo.getMerchantNo());
        if (payTransaction.getId() == null) {
            payTransaction.setDt(new Date());
            payTransactionService.save(payTransaction);
        } else {
            payTransactionService.updateById(payTransaction);
        }

        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", uuid);
        bizContent.put("total_amount", payTransactionBo.getAmount());
        bizContent.put("subject", "支付宝扫码下单");
        // 商户实际经营主体的小程序应用的appid
        bizContent.put("product_code", "FACE_TO_FACE_PAYMENT");
        request.setNotifyUrl(ALI_PAY_NOTIFY_URL);
        request.setBizContent(bizContent.toString());
        log.info("支付宝扫码下单 data:{}", bizContent.toJSONString());
        AlipayTradePrecreateResponse response;
        try {
            response = getAlipayClient("2021003129694075").certificateExecute(request, null, tempRedis.getRvalue());
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
        if (response.isSuccess()) {
            //下单成功
            byte[] qr = QrCodeUtil.generatePng(response.getQrCode(), 200, 200);
            String fileName = String.join(StringPool.UNDERSCORE, System.currentTimeMillis() + "", payTransactionBo.getOrderId(), ".png");
            OssInfo ossInfo = localOssClient.upLoad(new ByteArrayInputStream(qr), fileName);
            return ScanPayApplyRes.builder()
                    .orderId(payTransactionBo.getOrderId())
                    .scanQrCode(ossInfo.getFileLink())
                    .tradeNo(uuid).build();
        } else {
            PayTransaction updatePayTransaction = PayTransaction.builder()
                    .id(payTransaction.getId())
                    .status(2)
                    .remark(String.join(",", response.getMsg(), response.getSubMsg()))
                    .build();
            payTransactionService.updateById(updatePayTransaction);
            throw new BizException("支付宝创建订单失败:" + response.getSubMsg());
        }
    }

}
