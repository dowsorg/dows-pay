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
 * 支付业务(PayBiz)表单
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
@ApiModel(value = "PayBizForm 表单对象", description = "支付业务")
public class PayBizForm implements Serializable {
    private static final long serialVersionUID = 803860252890346690L;
    @JsonIgnore
    private Long id;

    @ApiModelProperty("父ID")
    private Long pid;

    @ApiModelProperty("业务编号")
    private String bizNo;

    @ApiModelProperty("业务code")
    private String bizCode;

    @ApiModelProperty("业务名称|业务组名称")
    private String bizName;

    @ApiModelProperty("名称空间")
    private String bizNamespace;

    @ApiModelProperty("规则编号或ID")
    private String ruleNo;

    @ApiModelProperty("规则名称")
    private String ruleName;

    @ApiModelProperty("状态")
    private Integer state;

    @ApiModelProperty("价格")
    private Object price;

    @JsonIgnore
    private Date dt;

    @JsonIgnore
    private Boolean deleted;


}

