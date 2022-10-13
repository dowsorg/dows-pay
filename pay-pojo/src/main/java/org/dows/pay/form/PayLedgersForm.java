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
 * 支付-分账账本(PayLedgers)表单
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
@ApiModel(value = "PayLedgersForm 表单对象", description = "支付-分账账本")
public class PayLedgersForm implements Serializable {
    private static final long serialVersionUID = 390177657342931500L;
    @JsonIgnore
    private Long id;

    @ApiModelProperty("支付通道实例编号")
    private String instanceNo;

    @ApiModelProperty("商户号")
    private String merchantNo;

    @ApiModelProperty("应用ID")
    private String appId;

    @ApiModelProperty("分账接收者ID(统一账号ID)")
    private String accountId;

    @ApiModelProperty("接收者账号别名")
    private String accountName;

    @ApiModelProperty("用户真实名")
    private String userName;

    @ApiModelProperty("通道ID")
    private String channelId;

    @ApiModelProperty("服务商code")
    private String channelCode;

    @ApiModelProperty("通道应用ID")
    private String channelAppId;

    @ApiModelProperty("分账接收账号（支付宝|微信等第三方通道账号[账号ID,支付宝账接收方方类型，userId：表示是支付宝账号对应的支付宝唯一用户号；]）")
    private String channelAccountNo;

    @ApiModelProperty("分账接收账号名称（第三方通道账号，如支付宝loginName：表示是支付宝登录号名|微信）")
    private String channelAccountName;

    @ApiModelProperty("分账接收账号类型: 0-个人(对私) 1-商户(对公)")
    private Boolean channelAccountType;

    @ApiModelProperty("分账状态（本系统状态，并不调用上游关联关系）: 1-正常分账, 0-暂停分账")
    private Boolean state;

    @ApiModelProperty("分账比例")
    private BigDecimal allocationProfit;

    @JsonIgnore
    private Boolean deleted;


}

