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
 * 支付通道状态码(PayCode)表单
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
@ApiModel(value = "PayCodeForm 表单对象", description = "支付通道状态码")
public class PayCodeForm implements Serializable {
    private static final long serialVersionUID = -81062001013586044L;
    @JsonIgnore
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

    @JsonIgnore
    private Date dt;

    @JsonIgnore
    private Boolean deleted;


}

