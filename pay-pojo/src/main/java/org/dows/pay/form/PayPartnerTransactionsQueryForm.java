package org.dows.pay.form;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.dows.pay.api.BizForm;
import org.dows.pay.api.annotation.WeixinApiField;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 支付交易(PayTransaction)表单
 *
 * @author lait.zhang
 * @since 2022-09-25 10:14:06
 */
@SuppressWarnings("serial")
@Data
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "PayPartnerTransactionsQueryForm 表单对象", description = "查询支付")
public class PayPartnerTransactionsQueryForm implements Serializable, BizForm {
    @JsonIgnore
    private Long id;

    @ApiModelProperty("交易号")
    private String transactionNo;

    @ApiModelProperty("交易名称")
    private String transactionName;

    @ApiModelProperty("支付通道")
    private String payChannel;

    @ApiModelProperty("订单号")
    private String orderId;

    @ApiModelProperty("订单标题")
    private String orderTitle;

    @ApiModelProperty("应用id")
    private String appId;

    @ApiModelProperty("租户号")
    private String tenantId;

    @ApiModelProperty("交易状态")
    private Integer status;

    @ApiModelProperty("交易时间")
    private Date transactionTime;

    @JsonIgnore
    private Date dt;

    @JsonIgnore
    private Boolean deleted;


    /**
     * <pre>
     * 字段名：服务商户号
     * 变量名：sp_mchid
     * 是否必填：是
     * 类型：string（32）
     * 描述：
     *  服务商户号，由微信支付生成并下发
     * 示例值：1230000109
     * </pre>
     */
    @ApiModelProperty("服务商户号")
    private String spMchid;

    /**
     * <pre>
     * 字段名：二级商户号
     * 变量名：sub_mchid
     * 是否必填：是
     * 类型：string（32）
     * 描述：
     *  二级商户的商户号，有微信支付生成并下发。
     * 示例值：1900000109
     * </pre>
     */
    @ApiModelProperty("二级商户号")
    private String subMchid;

    /**
     * <pre>
     * 字段名：微信支付订单号
     * 变量名：transaction_id
     * 是否必填：是
     * 类型：string（32）
     * 描述：
     *  微信支付系统生成的订单号
     * 示例值：1217752501201407033233368018
     * </pre>
     */
    @ApiModelProperty("微信支付订单号")
    private String transactionId;
    /**
     * <pre>
     * 字段名：商户订单号
     * 变量名：out_trade_no
     * 是否必填：是
     * 类型：string（32）
     * 描述：
     *  商户系统内部订单号，只能是数字、大小写字母_-*且在同一个商户号下唯一，详见【商户订单号】。
     * 特殊规则：最小字符长度为6
     * 示例值：1217752501201407033233368018
     * </pre>
     */
    @ApiModelProperty("商户订单号")
    private String outTradeNo;


}

