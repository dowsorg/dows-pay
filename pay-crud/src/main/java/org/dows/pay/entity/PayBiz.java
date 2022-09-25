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
 * 支付业务(PayBiz)实体类
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
@ApiModel(value = "PayBiz对象", description = "支付业务")
public class PayBiz implements CrudEntity {
    private static final long serialVersionUID = 727617796782890427L;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("主键ID")
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
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

    @ApiModelProperty("时间戳")
    private Date dt;

    @JsonIgnore
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("逻辑删除")
    private Boolean deleted;

}

