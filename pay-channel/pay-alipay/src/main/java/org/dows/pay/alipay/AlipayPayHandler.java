package org.dows.pay.alipay;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.cron.timingwheel.SystemTimer;
import cn.hutool.cron.timingwheel.TimerTask;
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
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.account.api.AccountInstanceApi;
import org.dows.account.vo.AccountInstanceVo;
import org.dows.app.api.mini.AppBaseApi;
import org.dows.auth.api.TempRedisApi;
import org.dows.auth.biz.context.SecurityUtils;
import org.dows.auth.biz.redis.RedisServiceBiz;
import org.dows.auth.entity.TempRedis;
import org.dows.framework.api.exceptions.BizException;
import org.dows.framework.oss.api.OssInfo;
import org.dows.framework.oss.tencent.TencentOssClient;
import org.dows.order.api.OrderInstanceBizApiService;
import org.dows.order.bo.OrderAccountBo;
import org.dows.order.bo.OrderInstanceBo;
import org.dows.order.bo.OrderUpdatePaymentStatusBo;
import org.dows.order.form.OrderCashPayForm;
import org.dows.order.vo.OrderPayCodeVo;
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
import org.dows.pay.entity.*;
import org.dows.pay.form.AliPayRequest;
import org.dows.pay.mapper.PayLedgersRecordMapper;
import org.dows.pay.service.PayAccountService;
import org.dows.pay.service.PayApplyService;
import org.dows.pay.service.PayLedgersService;
import org.dows.pay.service.PayTransactionService;
import org.dows.store.api.MerchantInstanceApi;
import org.dows.store.api.response.MerchantResponse;
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

    private final PayApplyService payApplyService;

    private final AppBaseApi baseApi;
    @Autowired
    private RedisServiceBiz redisService;

    private static final SystemTimer SYSTEMTIMER = new SystemTimer().start();

    @Autowired
    @Lazy
    private TencentOssClient tencentOssClient;

    private final PayLedgersService payLedgersService;

    private static final String ALI_PAY_NOTIFY_URL = "https://www.wozth.com/api/user/aliPay/notify";

    private final IdGenerator idGenerator = new SimpleIdGenerator();

    private final AccountInstanceApi accountInstanceApi;

    private final TempRedisApi tempRedisApi;

    private final MerchantInstanceApi merchantInstanceApi;

    private final OrderInstanceBizApiService orderInstanceBizApiService;


    /**
     * 支付宝付款码支付
     * @param aliPayRequest
     * @return
     */
    public AlipayTradePayResponse payByAuthCode(AliPayRequest aliPayRequest) {
        PayTransaction payTransaction = payTransactionService.getByOrderId(aliPayRequest.getOrderId());
        if (payTransaction == null) {
            payTransaction = new PayTransaction();
        }
        if (Objects.equals(payTransaction.getStatus(), 1)) {
            throw new BizException("该订单已支付,请勿重复发起");
        }
        OrderInstanceBo orderInstanceBo = orderInstanceBizApiService.getOne(aliPayRequest.getOrderId());
        if (orderInstanceBo == null) {
            throw new BizException("传入订单参数有误");
        }


        PayApply payApply = payApplyService.getByMerchantNoAndType(orderInstanceBo.getMerchantNo(),2);
        if(null == payApply){
            throw new BizException("支付宝支付能力为空");
        }
//        MerchantAppIdReq statusReq = new MerchantAppIdReq();
//        statusReq.setMerchantNo(orderInstanceBo.getMerchantNo());
//        statusReq.setMiniType(2);
//        Response<MerchantAppIdRes> appIdResponse = baseApi.getMiniAppIdByMerchantNo(statusReq);
//        if(!appIdResponse.getStatus()){
//            throw new BizException("获取支付appId失败");
//        }

        String appId = payApply.getAppId();
        if(StrUtil.isEmpty(appId)){
            throw new BizException("获取支付appId为空");
        }

        log.info("付款码支付获取的appId:{}",appId);

        TempRedis tempRedis = tempRedisApi.getKey(appId);
        if (Objects.isNull(tempRedis)) {
            throw new BizException("获取商家授权token为空,appId=" + appId);
        }

        String appAuthToken = tempRedis.getRvalue();
        log.info("付款码支付授权token:{}",appAuthToken);
        //先创建交易订单
        String uuid =  IdUtil.fastSimpleUUID();
        payTransaction.setPayChannel("aliPay");
        payTransaction.setTransactionNo(uuid);
        payTransaction.setAppId(appId);
        payTransaction.setOrderId(aliPayRequest.getOrderId());
        payTransaction.setMerchantNo(SecurityUtils.getMerchantNo());
        if (payTransaction.getId() == null) {
            payTransactionService.save(payTransaction);
        }

        AlipayTradePayRequest request = new AlipayTradePayRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", uuid);

        bizContent.put("subject", aliPayRequest.getSubject());
        bizContent.put("timeout_express", "10m");
        //bizContent.put("seller_id",aliPayRequest.getSellerId());
        bizContent.put("scene", "bar_code");
        bizContent.put("auth_code", aliPayRequest.getAuthCode());
        request.setNotifyUrl(ALI_PAY_NOTIFY_URL);

         //计算优惠金额
        if(!CollUtil.isEmpty(aliPayRequest.getCouponInfoList()) || aliPayRequest.getDiscount() != null) {
            OrderCashPayForm orderCashPayForm = new OrderCashPayForm();
            orderCashPayForm.setOrderId(aliPayRequest.getOrderId());
            List<OrderCashPayForm.StoreCouponInfo> couponInfoList = BeanUtil.copyToList(aliPayRequest.getCouponInfoList(), OrderCashPayForm.StoreCouponInfo.class);
            orderCashPayForm.setCouponInfoList(couponInfoList);
            orderCashPayForm.setDiscount(aliPayRequest.getDiscount());
            OrderPayCodeVo orderPayCodeVo = orderInstanceBizApiService.paymentCode(orderCashPayForm);
            log.info("AliPayHandler.micropay calc result:{}"+JSON.toJSONString(orderPayCodeVo));
            if(Integer.valueOf(1).equals(orderPayCodeVo.getStatus())){
                AlipayTradePayResponse alipayTradePayResponse = new AlipayTradePayResponse();
                alipayTradePayResponse.setCode("10000");
                alipayTradePayResponse.setMsg("Success");
                return alipayTradePayResponse;
            }
        }
        //组装订单逻辑
        OrderInstanceBo orderInstance = orderInstanceBizApiService.getOne(orderInstanceBo.getOrderId(),true);
        bizContent.put("total_amount", orderInstance.getAgreeAmout());
        log.info("付款码支付传入支付宝参数:{}",bizContent.toJSONString());
        request.setBizContent(bizContent.toString());
        AlipayTradePayResponse response;
        try {
            response = getAlipayClient("2021003129694075").certificateExecute(request, null, appAuthToken);
        } catch (AlipayApiException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        log.info("alipay扫码支付返回:{}",JSON.toJSONString(response));
        if ("10000".equals(response.getCode())) {
            //下单成功
            PayTransaction updatePayTransaction = PayTransaction.builder()
                    .id(payTransaction.getId())
                    .dealTo(response.getTradeNo())
                    .status(1)
                    .amount(orderInstance.getAgreeAmout())
                    .build();
            payTransactionService.updateById(updatePayTransaction);
            //更新支付人
            OrderAccountBo orderAccountBo = new OrderAccountBo();
            orderAccountBo.setOrderId(orderInstanceBo.getOrderId());
            orderAccountBo.setPayAccountId("用户");
            String tableId = redisService.getCacheObject("emptyTableIdOrderId:" + payTransaction.getOrderId());
            orderAccountBo.setTableId(tableId);
            orderInstanceBizApiService.updateOrderAccountId(orderAccountBo);
        }else if("10003".equals(response.getCode())){
            //等待付款查询支付状态
            delayQueryOrder(payTransaction,1,"用户");
        } else {
            PayTransaction updatePayTransaction = PayTransaction.builder()
                    .id(payTransaction.getId())
                    .status(2)
                    .remark(String.join(",", response.getMsg(), response.getSubMsg()))
                    .build();
            payTransactionService.updateById(updatePayTransaction);
            throw new BizException("支付宝扫码支付失败:" + response.getSubMsg());
        }
        return response;
    }


    /**
     * 延迟查询订单
     * @param payTransaction
     * @param times
     */
    private void delayQueryOrder(PayTransaction payTransaction,final int times,String accountId) {
        SYSTEMTIMER.addTask(new TimerTask(()->{
            try {
                AlipayTradeQueryResponse alipayTradeQueryResponse = null;
                    alipayTradeQueryResponse = queryOrderPayStatus(payTransaction.getTransactionNo());

                log.info("query order alipay result:{}"+JSON.toJSONString(alipayTradeQueryResponse));
                if("WAIT_BUYER_PAY".equals(alipayTradeQueryResponse.getTradeStatus())){//支付中
                    int newTimes = times+1;
                    if(newTimes<=60){
                        delayQueryOrder(payTransaction,newTimes,accountId);
                    }
                }
                if("TRADE_SUCCESS".equals(alipayTradeQueryResponse.getTradeStatus())){//支付成功
                    log.info("支付成功");
                    PayTransaction updatePayTransaction = PayTransaction.builder()
                            .id(payTransaction.getId())
                            .amount(new BigDecimal(alipayTradeQueryResponse.getPayAmount()))
                            .status(1)
                            .dealTo(alipayTradeQueryResponse.getTradeNo())
                            .build();
                    payTransactionService.updateById(updatePayTransaction);
                    //更新支付人
                    OrderAccountBo orderAccountBo = new OrderAccountBo();
                    orderAccountBo.setOrderId(updatePayTransaction.getOrderId());
                    orderAccountBo.setPayAccountId(accountId);
                    String tableId = redisService.getCacheObject("emptyTableIdOrderId:" + payTransaction.getOrderId());
                    orderAccountBo.setTableId(tableId);
                    orderInstanceBizApiService.updateOrderAccountId(orderAccountBo);
                    //更新订单状态
                    updateOrderStatusForSucc(payTransaction);
                }



            } catch (AlipayApiException e) {
                e.printStackTrace();
            }
        }, 60000));
    }

    /**
     * 更新订单状态
     * @param payTransaction
     */
    private void updateOrderStatusForSucc(PayTransaction payTransaction){
        OrderUpdatePaymentStatusBo instanceBo = new OrderUpdatePaymentStatusBo();
        instanceBo.setTradeStatus(3);
        instanceBo.setPayChannel(2);
        instanceBo.setTradeType(1);
        instanceBo.setOrderId(payTransaction.getOrderId());
        orderInstanceBizApiService.updateOrderInstance(instanceBo);
    }




    /**
     * 查询订单支付状态
     * @param outTradeNo
     * @return
     * @throws AlipayApiException
     */
    private AlipayTradeQueryResponse queryOrderPayStatus(String outTradeNo) throws AlipayApiException {
        AlipayTradeQueryRequest alipayTradeQueryRequest = new AlipayTradeQueryRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", outTradeNo);
        alipayTradeQueryRequest.setBizContent(bizContent.toString());
        return getAlipayClient("2021003129694075").execute(alipayTradeQueryRequest);
    }





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
        String uuid =  IdUtil.fastSimpleUUID();
        payTransaction.setPayChannel("aliPay");
        payTransaction.setTransactionNo(uuid);
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
        // 商户实际经营主体的小程序应用的appid
        bizContent.put("op_app_id", orderInstanceBo.getAppId());
        bizContent.put("product_code", "FACE_TO_FACE_PAYMENT");
        request.setNotifyUrl(ALI_PAY_NOTIFY_URL);
        request.setBizContent(bizContent.toString());
        AlipayTradeCreateResponse response;
        try {
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
            e.printStackTrace();
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
        MerchantResponse merchantByNo = merchantInstanceApi.getMerchantByNo(merchantNo);
        if (Objects.isNull(merchantByNo)) {
            log.error("根据商户号:【{}】查询商户信息为空",merchantNo);
            return;
        }

        if (Objects.isNull(merchantByNo.getAlipayCommissionRatio())) {
            log.error("根据商户号:【{}】查询商户支付宝结算利率为空",merchantNo);
            return;
        }

        // 暂定20%比例
        BigDecimal separateAmount = orderInstanceBo.getAgreeAmout().multiply(BigDecimal.valueOf(merchantByNo.getAlipayCommissionRatio()))
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
                payAccount.getChannelMerchantNo(), separateAmount.multiply(new BigDecimal("100")), merchantByNo.getAlipayCommissionRatio()+"");
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
                                                  String transOut, BigDecimal amount, String ratio) {
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
            OssInfo ossInfo = tencentOssClient.upLoad(new ByteArrayInputStream(qr), fileName);
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
