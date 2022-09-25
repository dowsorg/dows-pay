package org.dows.pay.form;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 支付规则(PayRule)表单
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
@ApiModel(value = "PayRuleForm 表单对象", description = "支付规则")
public class PayRuleForm implements Serializable {
    private static final long serialVersionUID = -78136587693644683L;
    private Long id;

    @ApiModelProperty("规则编号")
    private String ruleNo;

    @ApiModelProperty("规则名称")
    private String ruleName;

    @ApiModelProperty("规则码")
    private String ruleCode;

    @ApiModelProperty("提取接口，业务方提供，参数为ruleExpr，根据cron表达式")
    private String dataApi;

    @ApiModelProperty("通道编号(全局唯一)")
    private String channelNo;

    @ApiModelProperty("商户号")
    private String merchantNo;

    private Boolean deleted;

    private Date dt;


}

