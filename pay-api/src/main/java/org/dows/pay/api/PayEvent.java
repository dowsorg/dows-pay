package org.dows.pay.api;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class PayEvent<T extends PayMessage> extends ApplicationEvent {

    @Getter
    private T payMessage;

    public PayEvent(Object source, T payMessage) {
        super(source);
        this.payMessage = payMessage;
    }
}
