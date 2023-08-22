package org.dows.pay.api.request;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ScanPayReq implements Serializable {

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 商户号
     */
    private String merchantNo;

    /**
     * 应付金额
     */
    private BigDecimal amount;

    /**
     * 商家应用id
     */
    private String appId;
}
