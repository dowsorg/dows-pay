package org.dows.pay.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import org.dows.pay.api.PayEvent;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.event.OrderPaySuccessEvent;
import org.dows.pay.api.message.AlipayMessage;
import org.dows.pay.entity.PayChannel;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;

import java.io.IOException;
import java.util.TimerTask;

/**
 * 支付相关业务功能,如：，
 * 当面付：https://open.alipay.com/api/detail?code=I1080300001000041016
 * app付款：https://open.alipay.com/api/detail?code=I1080300001000041313
 */
public class AlipayPayHandler extends AbstractAlipayHandler {


    /**
     * 去支付
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_ORDER_PAY)
    public void toPay(PayRequest payRequest) {

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

        } else {
            //todo 失败逻辑
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
     * 分账结果通知
     */
    @EventListener(value = {PayEvent.class})
    public void onPaySuccessEvent(PayEvent<AlipayMessage> payEvent) {
        // todo 是否需要作记录log？
        OrderPaySuccessEvent orderPaySuccessEvent = new OrderPaySuccessEvent(null/*orderId,paySuccessTime,holdingTime, PayChannel.alipay*/);
        applicationEventPublisher.publishEvent(orderPaySuccessEvent);
    }

}
