package org.dows.pay.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.api.PayEvent;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.event.OrderPaySuccessEvent;
import org.dows.pay.api.message.AlipayMessage;
import org.dows.pay.bo.PayTransactionBo;
import org.dows.pay.entity.PayChannel;
import org.dows.pay.entity.PayTransaction;
import org.dows.pay.service.PayTransactionService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;
import org.springframework.util.SimpleIdGenerator;

import java.io.IOException;
import java.util.TimerTask;
import java.util.UUID;

/**
 * 支付相关业务功能,如：，
 * 当面付：https://open.alipay.com/api/detail?code=I1080300001000041016
 * app付款：https://open.alipay.com/api/detail?code=I1080300001000041313
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class AlipayPayHandler extends AbstractAlipayHandler {

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
        PayTransaction payTransaction = PayTransaction.builder()
                    .payChannel(payRequest.getChannel())
                    .transactionName(payTransactionBo.getTransactionName())
                    .transactionNo(uuid.toString())
                    .amount(payTransactionBo.getAmount())
                    .appId(payRequest.getAppId())
                    .build();
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
    public void onPaySuccessEvent(PayEvent<AlipayMessage> payEvent) {
        // todo 是否需要作记录log？
        OrderPaySuccessEvent orderPaySuccessEvent = new OrderPaySuccessEvent(null/*orderId,paySuccessTime,holdingTime, PayChannel.alipay*/);
        applicationEventPublisher.publishEvent(orderPaySuccessEvent);
    }

}
