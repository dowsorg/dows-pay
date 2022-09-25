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
 * 支付卡号绑定（后期放在钱包模块）(PayBinded)实体类
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
@ApiModel(value = "PayBinded对象", description = "支付卡号绑定（后期放在钱包模块）")
public class PayBinded implements CrudEntity {
    private static final long serialVersionUID = -62427328109501295L;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("主键ID")
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("通道ID")
    private Long channelId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("账号ID")
    private Long accountId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("身份证号")
    private String idcard;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("银行卡号")
    private String bankcard;

    @ApiModelProperty("银行简码")
    private String bankCode;

    @ApiModelProperty("预留手机号")
    private String phone;

    @ApiModelProperty("协议id")
    private String protocolId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("应用id")
    private Long appId;

    @ApiModelProperty("时间戳")
    private Date dt;

    @JsonIgnore
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("逻辑删除")
    private Boolean deleted;

}

