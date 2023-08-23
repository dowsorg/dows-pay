package org.dows.pay.api.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class PayQueryRes implements Serializable {

    private String orderId;

    private String outTradeNo;

    private String payChannel;

    private BigDecimal payAmount;

    private String payDesc;

    private Date payTime;
}
