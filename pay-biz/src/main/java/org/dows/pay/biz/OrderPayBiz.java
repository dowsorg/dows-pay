package org.dows.pay.biz;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.pay.api.event.OrderPaySuccessEvent;
import org.dows.pay.api.request.OrderPayRequest;
import org.dows.pay.gateway.PayDispatcher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;


/**
 * 支付业务
 */

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderPayBiz {



    private final PayDispatcher payDispatcher;

    public Response toPay(OrderPayRequest orderPayRequest) {
        payDispatcher.dispatcher(orderPayRequest);
        return null;
    }


    @EventListener(value = {OrderPaySuccessEvent.class})
    public String onPaySuccessEvent(OrderPaySuccessEvent orderPaySuccessEvent) {
        doOrderAllocation();
        return null;
    }


    private void doOrderAllocation() {
        // todo 修改订单状态（该事件需要解耦通知其他域），
        // todo 插入预分账记录，
        // todo 根据当前支付（orderId:分账时间[支付成功时间+holdingTime]） 推送到队列(顺序规则，批量规则，定时规则) 设置并启动该比支付的分账定时任务
        // todo 计算分账任务执行时间 订单号 + 通道 + 分账时间[paySuccessTime+holdingTime ]
    }
}
