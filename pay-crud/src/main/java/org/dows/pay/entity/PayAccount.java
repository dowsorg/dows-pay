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
 * 支付通道账号(PayAccount)实体类
 *
 * @author lait.zhang
 * @since 2022-09-25 10:13:08
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "PayAccount对象", description = "支付通道账号")
public class PayAccount implements CrudEntity {
    private static final long serialVersionUID = 330899096783242797L;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("主键ID")
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("父ID")
    private Long pid;

    @ApiModelProperty("通道编号(全局唯一)")
    private String channelNo;

    @ApiModelProperty("通道码")
    private String channelCode;

    @ApiModelProperty("通道账号")
    private String channelAccount;

    @ApiModelProperty("通道商户号")
    private String channelMerchantNo;

    @ApiModelProperty("商户号")
    private String merchantNo;

    @ApiModelProperty("账号")
    private String accountNo;

    @ApiModelProperty("通道账号类型（0：个人账号，1：商户账号，11：商户子账号....）")
    private Integer cat;

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

