package org.dows.pay.form;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 支付卡号绑定（后期放在钱包模块）(PayBinded)表单
 *
 * @author lait.zhang
 * @since 2022-09-25 10:14:05
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "PayBindedForm 表单对象", description = "支付卡号绑定（后期放在钱包模块）")
public class PayBindedForm implements Serializable {
    private static final long serialVersionUID = 545855900786709532L;
    @JsonIgnore
    private Long id;

    @ApiModelProperty("通道ID")
    private Long channelId;

    @ApiModelProperty("账号ID")
    private Long accountId;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("身份证号")
    private String idcard;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("银行卡号")
    private String bankcard;

    @ApiModelProperty("银行简码")
    private String bankCode;

    @ApiModelProperty("预留手机号")
    private String phone;

    @ApiModelProperty("协议id")
    private String protocolId;

    @ApiModelProperty("应用id")
    private Long appId;

    @JsonIgnore
    private Date dt;

    @JsonIgnore
    private Boolean deleted;


}

