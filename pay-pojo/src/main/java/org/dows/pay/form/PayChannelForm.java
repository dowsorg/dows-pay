package org.dows.pay.form;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 支付通道(PayChannel)表单
 *
 * @author lait.zhang
 * @since 2022-09-25 09:35:52
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "PayChannelForm 表单对象", description = "支付通道")
public class PayChannelForm implements Serializable {
    private static final long serialVersionUID = 738690371780646088L;
    private Long id;

    @ApiModelProperty("通道编号(全局唯一)")
    private String channelNo;

    @ApiModelProperty("通道名称")
    private String channelName;

    @ApiModelProperty("通道码")
    private String channelCode;

    @ApiModelProperty("支付页面")
    private String channelHome;

    @ApiModelProperty("描述")
    private String descr;

    private Date dt;

    private Boolean deleted;


}

