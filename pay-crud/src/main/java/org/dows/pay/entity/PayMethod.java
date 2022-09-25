package org.dows.pay.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.dows.framework.crud.mybatis.CrudEntity;

/**
 * 支付方法(PayMethod)实体类
 *
 * @author lait.zhang
 * @since 2022-09-25 09:55:44
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "PayMethod对象", description = "支付方法")
public class PayMethod implements CrudEntity {
    private static final long serialVersionUID = 414519801900622347L;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("主键ID")
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

    @ApiModelProperty("时间戳")
    private Date dt;

    @JsonIgnore
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("逻辑删除")
    private Boolean deleted;

}

