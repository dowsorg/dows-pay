package org.dows.pay.alipay;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.msg.AlipayMsgClient;
import com.alipay.api.request.AlipayTradeCreateRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradeCreateResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.account.api.AccountInstanceApi;
import org.dows.account.vo.AccountInstanceResVo;
import org.dows.account.vo.AccountInstanceVo;
import org.dows.auth.api.TempRedisApi;
import org.dows.auth.entity.TempRedis;
import org.dows.framework.api.exceptions.BizException;
import org.dows.framework.oss.api.OssInfo;
import org.dows.framework.oss.tencent.TencentOssClient;
import org.dows.order.bo.OrderInstanceBo;
import org.dows.pay.api.PayEvent;
import org.dows.pay.api.PayException;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.event.OrderPaySuccessEvent;
import org.dows.pay.api.message.AlipayMessage;
import org.dows.pay.api.request.FacePayCreateRes;
import org.dows.pay.api.request.ScanPayApplyRes;
import org.dows.pay.bo.PayTransactionBo;
import org.dows.pay.boot.PayClientFactory;
import org.dows.pay.boot.properties.PayClientProperties;
import org.dows.pay.entity.PayTransaction;
import org.dows.pay.form.AliPayRequest;
import org.dows.pay.form.PayTransactionForm;
import org.dows.pay.service.PayTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;
import org.springframework.util.SimpleIdGenerator;
import org.dows.auth.biz.context.SecurityUtils;
import org.dows.order.api.OrderInstanceBizApiService;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
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

    @Lazy
    @Autowired
    private TencentOssClient localOssClient;

    private static final String ALI_PAY_NOTIFY_URL = "https://www.dxzsaas.com/api/user/aliPay/notify";

    private final IdGenerator idGenerator = new SimpleIdGenerator();

    private final AccountInstanceApi accountInstanceApi;

    private final TempRedisApi tempRedisApi;

    private final OrderInstanceBizApiService orderInstanceBizApiService;

    /**
     * 去支付
     *
     * @param payTransactionBo
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_ORDER_PAY)
    public AlipayTradeCreateResponse toPay(AliPayRequest payTransactionBo) {
        PayTransaction payTransaction = payTransactionService.getByOrderId(payTransactionBo.getOrderId());
        if (payTransaction == null) {
            payTransaction = new PayTransaction();
        }
        if (Objects.equals(payTransaction.getStatus(),1)) {
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
            throw new BizException("用户账号查询为空 accountId=:"+accountId);
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
        if (payTransaction.getId() ==null) {
            payTransactionService.save(payTransaction);
        }

        AlipayTradeCreateRequest request = new AlipayTradeCreateRequest ();
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
            response = getAlipayClient("2021003129694075").certificateExecute(request,null,tempRedis.getRvalue());
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
                    .remark(String.join(",",response.getMsg(),response.getSubMsg()))
                    .build();
            payTransactionService.updateById(updatePayTransaction);
            throw new BizException("支付宝创建订单失败:"+response.getSubMsg());
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
       log.info("aliPay onPaySuccessEvent :{}",JSON.toJSONString(payEvent));
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



    public ScanPayApplyRes scanPay(AliPayRequest payTransactionBo) {

        PayTransaction payTransaction = payTransactionService.getByOrderId(payTransactionBo.getOrderId());
        if (payTransaction == null) {
            payTransaction = new PayTransaction();
        }
        if (Objects.equals(payTransaction.getStatus(),1)) {
            throw new BizException("该订单已支付,请勿重复发起");
        }
        OrderInstanceBo orderInstanceBo = orderInstanceBizApiService.getOne(payTransactionBo.getOrderId());
        if (orderInstanceBo == null) {
            throw new BizException("传入订单参数有误");
        }
        String appId = orderInstanceBo.getAppId();
        TempRedis tempRedis = tempRedisApi.getKey(appId);
        if (Objects.isNull(tempRedis)) {
            throw new BizException("获取商家授权token为空,appId=" + appId);
        }
        //先创建交易订单
        String uuid = IdUtil.fastSimpleUUID();
        payTransaction.setOrderId(payTransactionBo.getOrderId());
        payTransaction.setPayChannel("aliPay");
        payTransaction.setTransactionNo(uuid);
        payTransaction.setAppId(orderInstanceBo.getAppId());
        payTransaction.setMerchantNo(SecurityUtils.getMerchantNo());
        if (payTransaction.getId() ==null) {
            payTransactionService.save(payTransaction);
        } else {
            payTransactionService.updateById(payTransaction);
        }

        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest ();
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", uuid);
        bizContent.put("total_amount", orderInstanceBo.getAgreeAmout());
        bizContent.put("subject", "支付宝扫码下单");
        // 商户实际经营主体的小程序应用的appid
        bizContent.put("product_code", "FACE_TO_FACE_PAYMENT");
        request.setNotifyUrl(ALI_PAY_NOTIFY_URL);
        request.setBizContent(bizContent.toString());
        AlipayTradePrecreateResponse response;
        try {
            // appId="2021004100609101"   token="202307BB6204a0ec6a3c4f7ebf83e7c993cc6X96"
            response = getAlipayClient("2021003129694075").certificateExecute(request,null,tempRedis.getRvalue());
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
        if (response.isSuccess()) {
            //下单成功
            byte[] qr = QrCodeUtil.generatePng(response.getQrCode(), 200, 200);
            String fileName = DateUtil.formatDate(DateUtil.date())+payTransactionBo.getOrderId() + ".png";
            OssInfo ossInfo = localOssClient.upLoad(new ByteArrayInputStream(qr), fileName);
            return ScanPayApplyRes.builder()
                    .orderId(payTransactionBo.getOrderId())
                    .scanQrCode(ossInfo.getFileLink())
                    .tradeNo(uuid).build();
        } else {
            PayTransaction updatePayTransaction = PayTransaction.builder()
                    .id(payTransaction.getId())
                    .status(2)
                    .remark(String.join(",",response.getMsg(),response.getSubMsg()))
                    .build();
            payTransactionService.updateById(updatePayTransaction);
            throw new BizException("支付宝创建订单失败:"+response.getSubMsg());
        }
    }

}
