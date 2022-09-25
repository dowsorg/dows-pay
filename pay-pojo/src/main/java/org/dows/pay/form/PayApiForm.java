package org.dows.pay.form;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 支付通道接口(PayApi)表单
 *
 * @author lait.zhang
 * @since 2022-09-25 10:14:05
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "PayApiForm 表单对象", description = "支付通道接口")
public class PayApiForm implements Serializable {
    private static final long serialVersionUID = 657762549610517959L;
    @JsonIgnore
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

    @JsonIgnore
    private Date dt;

    @JsonIgnore
    private Boolean deleted;


}

