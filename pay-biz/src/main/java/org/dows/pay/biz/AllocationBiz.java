package org.dows.pay.biz;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.event.OrderPaySuccessEvent;
import org.dows.pay.api.request.OrderAllocationRequest;
import org.dows.pay.gateway.PayDispatcher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * 分账业务
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class AllocationBiz {

    private final PayDispatcher payDispatcher;


    //private final TimerTaskService timerTaskService;


    @EventListener(value = {OrderPaySuccessEvent.class})
    public String onPaySuccessEvent(OrderPaySuccessEvent orderPaySuccessEvent) {
        doDispatchOrderAllocation();
        return null;
    }




    //@Quartz()
    private void doDispatchOrderAllocation() {
        OrderAllocationRequest orderAllocationRequest = new OrderAllocationRequest();
        orderAllocationRequest.setMethod(PayMethods.TRADE_ORDER_SETTLE.getNamespace());
        payDispatcher.dispatcher(orderAllocationRequest);
    }
}
