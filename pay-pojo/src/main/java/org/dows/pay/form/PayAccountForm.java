package org.dows.pay.form;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 支付通道账号(PayAccount)表单
 *
 * @author lait.zhang
 * @since 2022-09-25 09:35:52
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "PayAccountForm 表单对象", description = "支付通道账号")
public class PayAccountForm implements Serializable {
    private static final long serialVersionUID = 989685887117167002L;
    private Long id;

    @ApiModelProperty("父ID")
    private Long pid;

    @ApiModelProperty("通道编号(全局唯一)")
    private String channelNo;

    @ApiModelProperty("通道码")
    private String channelCode;

    @ApiModelProperty("通道账号")
    private String channelAccount;

    @ApiModelProperty("通道商户号")
    private String channelMerchantNo;

    @ApiModelProperty("商户号")
    private String merchantNo;

    @ApiModelProperty("账号")
    private String accountNo;

    @ApiModelProperty("通道账号类型（0：个人账号，1：商户账号，11：商户子账号....）")
    private Integer cat;

    @ApiModelProperty("状态")
    private Integer state;

    private Date dt;

    private Boolean deleted;


}

