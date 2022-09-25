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
 * 支付商户(PayMerchant)表单
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
@ApiModel(value = "PayMerchantForm 表单对象", description = "支付商户")
public class PayMerchantForm implements Serializable {
    private static final long serialVersionUID = 244202685667544183L;
    @JsonIgnore
    private Long id;

    @ApiModelProperty("平台商户号")
    private String merchantNo;

    @ApiModelProperty("内部支付账号")
    private String payAccount;

    @ApiModelProperty("内部支付密码")
    private String payPwd;

    @ApiModelProperty("内部账号名")
    private String accountName;

    @ApiModelProperty("内部账号")
    private String accountNo;

    @ApiModelProperty("应用id")
    private String appId;

    @ApiModelProperty("租户号")
    private String tentantNo;

    @ApiModelProperty("状态")
    private Integer state;

    @JsonIgnore
    private Date dt;

    @JsonIgnore
    private Boolean deleted;


}

