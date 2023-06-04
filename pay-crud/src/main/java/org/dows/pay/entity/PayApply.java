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
 * 支付接入申请(PayApply)实体类
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
@ApiModel(value = "PayApply对象", description = "支付接入申请")
public class PayApply implements CrudEntity {
    private static final long serialVersionUID = -76435782566872047L;

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

    @ApiModelProperty("审核是否通过（0:否，1：是）")
    private Boolean checked;

    @ApiModelProperty("子商户号")
    private String subMchid;

    @ApiModelProperty("申请类型 1-微信 2-支付宝")
    private Integer applyType;

    /**
     * 1、APPLYMENT_STATE_EDITTING（编辑中）
     * 2、APPLYMENT_STATE_AUDITING（审核中）
     * 3、APPLYMENT_STATE_REJECTED（已驳回）
     * 4、APPLYMENT_STATE_TO_BE_CONFIRMED（待账户验证）
     * 5、APPLYMENT_STATE_TO_BE_SIGNED（待签约）
     * 6、APPLYMENT_STATE_SIGNING（开通权限中）
     * 7、APPLYMENT_STATE_FINISHED（已完成）
     * 8、APPLYMENT_STATE_CANCELED（已作废）
     *
     */
    @ApiModelProperty("申请状态")
    private String applymentState;

    @ApiModelProperty("申请状态描述")
    private String applymentStateDesc;


    @JsonIgnore
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("逻辑删除")
    private Boolean deleted;

    @ApiModelProperty("时间戳")
    private Date dt;

    @ApiModelProperty("更新时间")
    private Date updateTime;

}

