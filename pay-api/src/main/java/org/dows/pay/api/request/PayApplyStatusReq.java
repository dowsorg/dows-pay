package org.dows.pay.api.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class PayApplyStatusReq implements Serializable {

    String merchantNo;
    /**
     * 审核单号
     */
    String auditId;
    /**
     * 1-微信 2-支付宝
     */
    @ApiModelProperty("1-微信 2-支付宝")
    private Integer applyType = 1;
    /**
     * 商家appId
     */
    String appId;

    /**
     * 是否已注册小程序
     */
    @ApiModelProperty("是否已注册小程序 false-否 true-是")
    private Boolean hasRegistered = false;

}
