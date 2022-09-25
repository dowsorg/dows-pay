package org.dows.pay.form;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 支付方法(PayMethod)表单
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
@ApiModel(value = "PayMethodForm 表单对象", description = "支付方法")
public class PayMethodForm implements Serializable {
    private static final long serialVersionUID = 384595449654902319L;
    private Long id;

    @ApiModelProperty("方法编号")
    private String methodNo;

    @ApiModelProperty("方法名称")
    private String methodName;

    @ApiModelProperty("方法名称空间")
    private String methodNamespace;

    @ApiModelProperty("方法参数")
    private String methodParams;

    @ApiModelProperty("方法URI")
    private String methodUri;

    @ApiModelProperty("重定向URL")
    private String redirectUrl;

    @ApiModelProperty("通知URL")
    private String notifyUrl;

    @ApiModelProperty("支付业务类型(......)")
    private String payTyp;

    @ApiModelProperty("环境（dev|test|ped|....)")
    private String env;

    @ApiModelProperty("业务组名称")
    private String bizGroup;

    @ApiModelProperty("描述")
    private String descr;

    private Date dt;

    private Boolean deleted;


}

