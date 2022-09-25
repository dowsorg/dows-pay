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
 * 支付指令集(PayDirective)表单
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
@ApiModel(value = "PayDirectiveForm 表单对象", description = "支付指令集")
public class PayDirectiveForm implements Serializable {
    private static final long serialVersionUID = -81624926835307694L;
    @JsonIgnore
    private Long id;

    @ApiModelProperty("指令编号")
    private String directiveNo;

    @ApiModelProperty("方法编号")
    private String methodNo;

    @ApiModelProperty("接口编号")
    private String apiNo;

    @ApiModelProperty("方法名称空间（bizNamespace）")
    private String methodNamespace;

    @ApiModelProperty("支付业务类型(......)")
    private String payTyp;

    @ApiModelProperty("环境（dev|test|ped|....)")
    private String env;

    @ApiModelProperty("业务编号")
    private String bizNo;

    @ApiModelProperty("业务名称")
    private String bizName;

    @ApiModelProperty("状态")
    private Integer state;

    @JsonIgnore
    private Date dt;

    @JsonIgnore
    private Boolean deleted;


}

