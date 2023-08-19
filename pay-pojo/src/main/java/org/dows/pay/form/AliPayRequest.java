package org.dows.pay.form;

import lombok.Data;

import java.io.Serializable;

@Data
public class AliPayRequest implements Serializable {

    /**
     * 前端必传
     */
    private String orderId;

    private String merchantNo;

    private String openId;

}
