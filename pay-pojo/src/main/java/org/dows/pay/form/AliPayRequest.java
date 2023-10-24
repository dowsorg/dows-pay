package org.dows.pay.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

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

    private String authCode;

    private String subject;

    private String sellerId;

    @ApiModelProperty(value = "劵信息")
    private List<PayTransactionForm.StoreCouponInfo> couponInfoList;

    @Data
    public static class StoreCouponInfo {

        @ApiModelProperty(value = "劵id")
        private String couponId;

        @ApiModelProperty(value = "劵金额")
        private BigDecimal amount;
    }

}
