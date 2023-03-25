package org.dows.pay.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.dows.pay.api.BizForm;
import org.dows.pay.api.ChannelBizModel;
import org.dows.pay.api.annotation.WeixinApiField;

import java.io.Serializable;
import java.util.Date;

/**
 * 支付交易(PayTransaction)表单
 *
 * @author lait.zhang
 * @since 2022-09-25 10:14:06
 */
@SuppressWarnings("serial")
@Data
public class PayPartnerTransactionsQueryBo implements ChannelBizModel {

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
    @WeixinApiField(name = "sp_mchid")
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
    @WeixinApiField(name = "sub_mchid")
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
    @WeixinApiField(name = "transaction_id")
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
    @WeixinApiField(name = "out_trade_no")
    @ApiModelProperty("商户订单号")
    private String outTradeNo;


}

