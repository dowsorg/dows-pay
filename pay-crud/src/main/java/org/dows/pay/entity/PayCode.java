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
 * 支付通道状态码(PayCode)实体类
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
@ApiModel(value = "PayCode对象", description = "支付通道状态码")
public class PayCode implements CrudEntity {
    private static final long serialVersionUID = -46217073123055121L;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("统一状态码编号")
    private String codeNo;

    @ApiModelProperty("接口编号")
    private String apiNo;

    @ApiModelProperty("通道编号(全局唯一)")
    private String channelNo;

    @ApiModelProperty("通道名称")
    private String channelName;

    @ApiModelProperty("通道码")
    private String channelCode;

    @ApiModelProperty("通道状态码")
    private String channelStateCode;

    @ApiModelProperty("通过状态码描述")
    private String channelStateDescr;

    @ApiModelProperty("统一状态码")
    private String statusCode;

    @ApiModelProperty("统一状态码描述")
    private String statusDescr;

    @ApiModelProperty("方法编号（一个方法可能存在多个code）")
    private String methodNo;

    @ApiModelProperty("时间戳")
    private Date dt;

    @JsonIgnore
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("逻辑删除")
    private Boolean deleted;

}

