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
 * 支付商户(PayMerchant)实体类
 *
 * @author lait.zhang
 * @since 2022-09-25 09:55:43
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "PayMerchant对象", description = "支付商户")
public class PayMerchant implements CrudEntity {
    private static final long serialVersionUID = 413558452133062958L;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("平台商户号")
    private String merchantNo;

    @ApiModelProperty("内部支付账号")
    private String payAccount;

    @ApiModelProperty("内部支付密码")
    private String payPwd;

    @ApiModelProperty("内部账号名")
    private String accountName;

    @ApiModelProperty("内部账号")
    private String accountNo;

    @ApiModelProperty("应用id")
    private String appId;

    @ApiModelProperty("租户号")
    private String tentantNo;

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

