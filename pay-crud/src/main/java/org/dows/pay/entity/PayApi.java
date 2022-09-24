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
 * 支付通道接口(PayApi)实体类
 *
 * @author lait.zhang
 * @since 2022-09-25 00:03:04
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "PayApi对象", description = "支付通道接口")
public class PayApi implements CrudEntity {
    private static final long serialVersionUID = -36823331091292755L;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("接口编号")
    private String apiNo;

    @ApiModelProperty("通道编号(全局唯一)")
    private String channelNo;

    @ApiModelProperty("通道码")
    private String channelCode;

    @ApiModelProperty("接口名称")
    private String apiName;

    @ApiModelProperty("接口namespace")
    private String apiCode;

    @ApiModelProperty("接口参数")
    private String apiParams;

    @ApiModelProperty("接口URI")
    private String apiUri;

    @ApiModelProperty("接口重定向URL")
    private String redirectUrl;

    @ApiModelProperty("接口通知地址")
    private String notifyUrl;

    @ApiModelProperty("环境（dev|test|ped|....)")
    private String env;

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

