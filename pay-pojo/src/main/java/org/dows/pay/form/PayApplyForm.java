package org.dows.pay.form;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 支付接入申请(PayApply)表单
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
@ApiModel(value = "PayApplyForm 表单对象", description = "支付接入申请")
public class PayApplyForm implements Serializable {
    private static final long serialVersionUID = -40140126847047451L;
    private Long id;

    @ApiModelProperty("申请编号")
    private String applyNo;

    @ApiModelProperty("商户号")
    private String merchantNo;

    @ApiModelProperty("全局唯一应用ID")
    private String appId;

    @ApiModelProperty("应用链接")
    private String appUrl;

    @ApiModelProperty("价格")
    private Object price;

    @ApiModelProperty("业务编号")
    private String bizNo;

    @ApiModelProperty("业务名称|业务组名称")
    private String bizName;

    @ApiModelProperty("审核是否通过（0:否，1：是）")
    private Boolean checked;

    private Boolean deleted;

    private Date dt;


}

