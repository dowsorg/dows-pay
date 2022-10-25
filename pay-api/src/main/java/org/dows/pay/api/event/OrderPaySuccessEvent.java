package org.dows.pay.api.event;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class OrderPaySuccessEvent extends ApplicationEvent {
    public OrderPaySuccessEvent(Object source) {
        super(source);
    }

    public OrderPaySuccessEvent(Object source, Clock clock) {
        super(source, clock);
    }
}
