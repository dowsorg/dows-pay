package org.dows.pay.api;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

public class PayEvent<T extends PayMessage> extends ApplicationEvent {

    @Getter
    private T payMessage;

    @Setter
    @Getter
    private Class<? extends PayHandler> handlerClass;

    public PayEvent(Object source, T payMessage) {
        super(source);
        this.payMessage = payMessage;
    }
}
