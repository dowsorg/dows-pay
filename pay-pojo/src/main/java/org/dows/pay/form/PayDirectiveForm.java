package org.dows.pay.form;

import java.util.Date;

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
 * @since 2022-09-25 09:35:52
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
    private static final long serialVersionUID = -27821136266903679L;
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

    private Date dt;

    private Boolean deleted;


}

