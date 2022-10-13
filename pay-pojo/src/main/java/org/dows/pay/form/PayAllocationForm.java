package org.dows.pay.form;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 支付-分账记录(PayAllocation)表单
 *
 * @author lait.zhang
 * @since 2022-10-13 14:17:12
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "PayAllocationForm 表单对象", description = "支付-分账记录")
public class PayAllocationForm implements Serializable {
    private static final long serialVersionUID = -39167945073421099L;
    @JsonIgnore
    private Long id;

    @ApiModelProperty("实际分得金额（订单实际分账金额, 单位：分（订单金额 - 商户手续费 - 已退款金额））")
    private BigDecimal allotedAmount;

    @ApiModelProperty("应分金额（计算该接收方的分账金额,单位分）")
    private BigDecimal allotAmount;

    @ApiModelProperty("订单金额,单位分")
    private BigDecimal payOrderAmount;

    @ApiModelProperty("系统支付订单号")
    private String payOrderId;

    @ApiModelProperty("分账记录ID")
    private String allotId;

    @ApiModelProperty("商户名称")
    private String merchantName;

    @ApiModelProperty("商户号")
    private String merchantNo;

    @ApiModelProperty("应用ID")
    private String appId;

    @ApiModelProperty("分账接收者ID(统一账号ID)快照")
    private String accountId;

    @ApiModelProperty("接收者账号别名快照")
    private String accountName;

    @ApiModelProperty("接收者姓名快照")
    private String userName;

    @ApiModelProperty("系统分账批次号")
    private String batchOrderId;

    @ApiModelProperty("服务商编码")
    private String channelCode;

    @ApiModelProperty("通道应用ID")
    private String channelAppId;

    @ApiModelProperty("支付订单渠道支付订单号")
    private String channelOrderNo;

    @ApiModelProperty("分账接收账号快照")
    private String channelAccountNo;

    @ApiModelProperty("分账接收账号名称快照")
    private String channelAccountName;

    @ApiModelProperty("上游分账批次号")
    private String channelBatchOrderId;

    @ApiModelProperty("类型: 1-普通商户, 2-特约商户(服务商模式)")
    private Boolean merchantType;

    @ApiModelProperty("分账接收账号类型: 0-个人(对私) 1-商户(对公)快照")
    private Boolean channelAccountType;

    @ApiModelProperty("状态: 0-待分账 1-分账成功, 2-分账失败")
    private Boolean state;

    @ApiModelProperty("分账比例快照> 配置的实际分账比例")
    private BigDecimal allocationProfit;

    @JsonIgnore
    private Boolean deleted;


}

