package org.dows.pay.entity;

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

import java.util.Date;

/**
 * 支付指令集(PayDirective)实体类
 *
 * @author lait.zhang
 * @since 2022-09-25 10:13:09
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "PayDirective对象", description = "支付指令集")
public class PayDirective implements CrudEntity {
    private static final long serialVersionUID = -42386783691270778L;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("主键ID")
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

    @ApiModelProperty("时间戳")
    private Date dt;

    @JsonIgnore
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("逻辑删除")
    private Boolean deleted;

}

