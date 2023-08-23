package org.dows.pay.form;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class AliPayRequest implements Serializable {

    /**
     * 前端必传
     */
    private String orderId;

    private String merchantNo;

    private String openId;

    private BigDecimal amount;

    private String appId;

}
