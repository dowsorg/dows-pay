package org.dows.pay.form;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 支付交易(PayTransaction)表单
 *
 * @author lait.zhang
 * @since 2022-09-25 09:35:53
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "PayTransactionForm 表单对象", description = "支付交易")
public class PayTransactionForm implements Serializable {
    private static final long serialVersionUID = -18329322274632955L;
    private Long id;

    @ApiModelProperty("交易号")
    private String transactionNo;

    @ApiModelProperty("交易名称")
    private String transactionName;

    @ApiModelProperty("支付通道")
    private String payChannel;

    @ApiModelProperty("订单号")
    private String orderId;

    @ApiModelProperty("订单标题")
    private String orderTitle;

    @ApiModelProperty("商户号")
    private String merchantNo;

    @ApiModelProperty("商户名称")
    private String merchantName;

    @ApiModelProperty("交易form方(accountNO)")
    private String dealForm;

    @ApiModelProperty("交易to方(accountNo)")
    private String dealTo;

    @ApiModelProperty("交易金额")
    private Object amount;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("应用id")
    private String appId;

    @ApiModelProperty("租户号")
    private String tenantId;

    @ApiModelProperty("交易状态")
    private Integer status;

    @ApiModelProperty("交易时间")
    private Date transactionTime;

    private Date dt;

    private Boolean deleted;


}

