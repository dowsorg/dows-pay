package org.dows.pay.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.dows.pay.api.BizForm;
import org.dows.pay.api.ChannelBizModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 支付交易Bo
 *
 */
@Data
public class PayTransactionBo implements ChannelBizModel {
    @JsonIgnore
    private Long id;

    private String transactionNo;

    private String transactionName;

    private String payChannel;

    private String orderId;

    private String orderTitle;

    private String merchantNo;

    private String merchantName;

    private String dealForm;

    private String dealTo;

    private Object amount;

    private String remark;

    private String appId;

    private String tenantId;

    private Integer status;

    @ApiModelProperty("用户登录子账户授权openId")
    private String subOpenid;

}

