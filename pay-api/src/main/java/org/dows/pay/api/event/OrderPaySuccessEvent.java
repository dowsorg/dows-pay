package org.dows.pay.api.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;
import java.util.Date;

public class OrderPaySuccessEvent extends ApplicationEvent {
    public OrderPaySuccessEvent(Object source) {
        super(source);
    }

    public OrderPaySuccessEvent(Object source, Clock clock) {
        super(source, clock);
    }

    public OrderPaySuccessEvent(Object source, String orderId, String payChannel, Date paySuccessTime, Date holdingTime) {
        super(source);
        this.orderId = orderId;
        this.payChannel = payChannel;
        this.paySuccessTime = paySuccessTime;
        this.holdingTime = holdingTime;
    }

    /** 订单号**/
    private String orderId;

    /** 支付channel**/
    private String payChannel;

    /** 支付时间 **/
    private Date paySuccessTime;

    /** 分账时间 **/
    private Date holdingTime;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public Date getPaySuccessTime() {
        return paySuccessTime;
    }

    public void setPaySuccessTime(Date paySuccessTime) {
        this.paySuccessTime = paySuccessTime;
    }

    public Date getHoldingTime() {
        return holdingTime;
    }

    public void setHoldingTime(Date holdingTime) {
        this.holdingTime = holdingTime;
    }
}
