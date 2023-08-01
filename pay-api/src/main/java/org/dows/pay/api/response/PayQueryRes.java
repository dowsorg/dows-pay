package org.dows.pay.api.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class PayQueryRes implements Serializable {

    private String orderId;

    private String outTradeNo;

    private String payChannel;

    private Integer payAmount;

    private String payDesc;

    private Date payTime;
}
