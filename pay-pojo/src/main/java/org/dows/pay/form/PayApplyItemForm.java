package org.dows.pay.form;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 支付接入申请明细(PayApplyItem)表单
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
@ApiModel(value = "PayApplyItemForm 表单对象", description = "支付接入申请明细")
public class PayApplyItemForm implements Serializable {
    private static final long serialVersionUID = -69389732325499010L;
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

    @ApiModelProperty("对业务方的回调接口")
    private String callbackApi;

    @ApiModelProperty("指令编号或ID")
    private String directiveNo;

    @ApiModelProperty("指令类型")
    private Integer directiveTyp;

    @ApiModelProperty("规则编号或ID")
    private String ruleNo;

    @ApiModelProperty("规则名称")
    private String ruleName;

    @ApiModelProperty("审核是否通过（0:否，1：是）")
    private Boolean checked;

    private Boolean deleted;

    private Date dt;


}

