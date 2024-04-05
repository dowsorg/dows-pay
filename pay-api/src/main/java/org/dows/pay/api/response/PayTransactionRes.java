package org.dows.pay.api.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.dows.pay.api.ChannelBizModel;

import java.math.BigDecimal;

/**
 * 支付交易Bo
 *
 */
@Data
public class PayTransactionRes implements ChannelBizModel {
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

    private BigDecimal amount;

    private String remark;

    private String appId;

    private String tenantId;

    private Integer status;

    @ApiModelProperty("用户登录子账户授权openId")
    private String subOpenid;

    private String tradeType;

}

