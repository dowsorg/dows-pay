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
 * 支付接入申请(PayApply)实体类
 *
 * @author lait.zhang
 * @since 2022-09-25 00:03:05
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "PayApply对象", description = "支付接入申请")
public class PayApply implements CrudEntity {
    private static final long serialVersionUID = 157039767099270291L;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("主键")
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

    @JsonIgnore
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("审核是否通过（0:否，1：是）")
    private Boolean checked;

    @JsonIgnore
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("逻辑删除")
    private Boolean deleted;

    @ApiModelProperty("时间戳")
    private Date dt;

}

