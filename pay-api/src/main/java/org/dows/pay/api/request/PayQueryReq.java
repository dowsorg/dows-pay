package org.dows.pay.api.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class PayQueryReq implements Serializable {

    private String orderId;

    private String outTradeNo;

}
