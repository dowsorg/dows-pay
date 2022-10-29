package org.dows.pay.alipay;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayRequest;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.msg.AlipayMsgClient;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.api.PayEvent;
import org.dows.pay.api.PayException;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.event.OrderPaySuccessEvent;
import org.dows.pay.api.message.AlipayMessage;
import org.dows.pay.bo.PayTransactionBo;
import org.dows.pay.boot.PayClientConfig;
import org.dows.pay.boot.PayClientFactory;
import org.dows.pay.boot.properties.PayClientProperties;
import org.dows.pay.entity.PayChannel;
import org.dows.pay.entity.PayTransaction;
import org.dows.pay.service.PayTransactionService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;
import org.springframework.util.SimpleIdGenerator;

import java.io.IOException;
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

    private final PayClientConfig payClientConfig;

    private final PayClientFactory payClientFactory;

    private final PayTransactionService payTransactionService;

    private final IdGenerator idGenerator = new SimpleIdGenerator();

    /**
     * 去支付
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_ORDER_PAY)
    public void toPay(PayRequest payRequest) {
        //先创建交易订单
        UUID uuid = idGenerator.generateId();
        PayTransactionBo payTransactionBo = (PayTransactionBo)payRequest.getBizModel();
        PayTransaction payTransaction = BeanUtil.copyProperties(payTransactionBo, PayTransaction.class);
        payTransaction.setPayChannel(payRequest.getChannel());
        payTransaction.setTransactionNo(uuid.toString());
        payTransaction.setAppId(payRequest.getAppId());
        payTransactionService.save(payTransaction);
        AlipayTradeAppPayModel alipayTradeAppPayModel = new AlipayTradeAppPayModel();
        // 自动
        autoMappingValue(payRequest, alipayTradeAppPayModel);
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        request.setBizModel(alipayTradeAppPayModel);
        AlipayTradeAppPayResponse response = null;
        try {
            response = getAlipayClient(payRequest.getAppId()).execute(request);
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
        if (response.isSuccess()) {
            System.out.println("调用成功");
            // todo 记录 pay_transaction表，可能有多次（失败），但只有一次是成功的
            //下单成功
            PayTransaction updatePayTransaction = PayTransaction.builder()
                    .id(payTransaction.getId())
                    .status(1) //下单成功
                    .build();
            payTransactionService.updateById(updatePayTransaction);
        } else {
            //todo 失败逻辑
            PayTransaction updatePayTransaction = PayTransaction.builder()
                    .id(payTransaction.getId())
                    .status(2) //下单失败
                    .build();
            payTransactionService.updateById(updatePayTransaction);
            throw new RuntimeException("调用失败");
        }
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
                .eq(PayTransaction::getOrderId, outTradeNo);
        PayTransaction payTransaction = payTransactionService.getOne(payTransactionWrapper);
        //支付成功或者失败 都告诉支付success
        if (payTransaction.getStatus().equals(3) || payTransaction.getStatus().equals(4)) {

            // 创建具体返回消息体
            AlipayRequest alipayRequest = null;
            alipayMsgClient.sendMessage(alipayRequest);
        }
        //获取key
        //调用SDK验证签名
        PayClientProperties payClientProperties = payClientConfig.getClientConfigs().stream()
                .filter(p -> p.getAppId().equalsIgnoreCase(appId))
                .findFirst()
                .orElse(null);
        if (payClientProperties != null) {
            String payCertPath = payClientProperties.getPayCertPath();
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
                payTransaction.setStatus(3);
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

}
