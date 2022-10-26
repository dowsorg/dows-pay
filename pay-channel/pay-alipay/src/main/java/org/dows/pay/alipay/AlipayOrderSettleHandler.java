package org.dows.pay.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.AlipayTradeOrderSettleModel;
import com.alipay.api.domain.RoyaltyDetail;
import com.alipay.api.request.AlipayTradeOrderSettleRequest;
import com.alipay.api.response.AlipayTradeOrderSettleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.api.PayEvent;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.message.AlipayMessage;
import org.dows.pay.entity.PayAllocation;
import org.dows.pay.service.PayAllocationService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * 收单业务(订单分账请求 及其消息通知 > 交易分账结果通知接口)
 * <p>
 * TRADE_ORDER_SETTLE("dows.trade.order.settle", "", "统一收单交易结算接口"),
 * <p>
 * TRADE_ORDER_SETTLE_NOTIFY("dows.trade.order.settle.notify", "", "交易分账结果通知"),
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class AlipayOrderSettleHandler extends AbstractAlipayHandler {

    private final PayAllocationService payAllocationService;


    /**
     * 统一收单交易结算接口
     * https://opendocs.alipay.com/open/02j2bt
     *
     * @param payRequest
     * @return
     */
    @PayMapping(method = PayMethods.TRADE_ORDER_SETTLE)
    public void tradeOrderSettle(PayRequest payRequest) {

        AlipayTradeOrderSettleModel alipayTradeRoyaltyRelationBindModel = new AlipayTradeOrderSettleModel();
        // 自动映射
        autoMappingValue(payRequest, alipayTradeRoyaltyRelationBindModel);

        AlipayTradeOrderSettleRequest request = new AlipayTradeOrderSettleRequest();
        request.setBizModel(alipayTradeRoyaltyRelationBindModel);
        AlipayTradeOrderSettleResponse response = null;
        try {
            response = getAlipayClient(payRequest.getAppId()).execute(request);
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }

        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            //todo 失败逻辑
            throw new RuntimeException("调用失败");
        }
    }


    /**
     * 收单交易分账结果通知
     * https://opendocs.alipay.com/open/02pj6n
     * RoyaltyDetail
     * RoyaltyDetailInfo
     * RoyaltyDetailInfos
     * RoyaltyEntity
     * RoyaltyInfo
     *
     * @param payEvent
     * @return
     */
    @EventListener(value = {PayEvent.class})
    public void onTradeOrderSettleEvent(PayEvent<AlipayMessage> payEvent) {
        AlipayMessage payMessage = payEvent.getPayMessage();
        log.info("处理  事件消息:{}", payMessage);
        // todo 业务处理
        String appId = payMessage.getAppId();
        String msgApi = payMessage.getMsgApi();
        String msgId = payMessage.getMsgId();

        // todo 更新PayAllocation表【时间、状态、实际分得金额】

        String bizContent = payMessage.getBizContent();

        RoyaltyDetail royaltyDetail = new RoyaltyDetail();

        PayAllocation payAllocation = PayAllocation.builder()
                .build();
        payAllocationService.updateById(payAllocation);

        log.info("业务响应:bizContent = {}", bizContent);
    }


}
