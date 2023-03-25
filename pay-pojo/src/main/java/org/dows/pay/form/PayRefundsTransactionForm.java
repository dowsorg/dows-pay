package org.dows.pay.form;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.dows.pay.api.BizForm;
import org.dows.pay.api.annotation.WeixinApiField;

import java.io.Serializable;
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
@ApiModel(value = "PayRefundsTransactionForm 表单对象", description = "退款交易")
public class PayRefundsTransactionForm implements Serializable, BizForm {
    private static final long serialVersionUID = -3186851559004865784L;
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
     * 字段名：二级商户号
     * 变量名：sub_mchid
     * 是否必填：是
     * 类型：string（32）
     * 描述：
     *  微信支付分配二级商户的商户号。
     *  示例值：1900000109
     * </pre>
     */
    @ApiModelProperty("二级商户号")
    private String subMchid;

    /**
     * <pre>
     * 字段名：电商平台APPID
     * 变量名：sp_appid
     * 是否必填：是
     * 类型：string（32）
     * 描述：
     *  电商平台在微信公众平台申请服务号对应的APPID，申请商户功能的时候微信支付会配置绑定关系。
     *  示例值：wx8888888888888888
     * </pre>
     */
    @ApiModelProperty("电商平台APPID")
    private String spAppid;

    /**
     * <pre>
     * 字段名：二级商户APPID
     * 变量名：sub_appid
     * 是否必填：否
     * 类型：string（32）
     * 描述：
     *  二级商户在微信申请公众号成功后分配的帐号ID，需要电商平台侧配置绑定关系才能传参。
     *  示例值：wxd678efh567hg6999
     * </pre>
     */
    @ApiModelProperty("二级商户APPID")
    private String subAppid;

    /**
     * <pre>
     * 字段名：微信订单号
     * 变量名：transaction_id
     * 是否必填：与out_order_no二选一
     * 类型：string（32）
     * 描述：
     *  微信支付订单号。
     *  示例值：4208450740201411110007820472
     * </pre>
     */
    @ApiModelProperty("微信订单号")
    private String transactionId;

    /**
     * <pre>
     * 字段名：商户订单号
     * 变量名：out_trade_no
     * 是否必填：与transaction_id二选一
     * 类型：string（64）
     * 描述：
     *   原支付交易对应的商户订单号。
     *   示例值：P20150806125346
     * </pre>
     */
    @ApiModelProperty("商户订单号")
    private String outTradeNo;

    /**
     * <pre>
     * 字段名：商户退款单号
     * 变量名：out_refund_no
     * 是否必填：是
     * 类型：string（64）
     * 描述：
     *   商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@，同一退款单号多次请求只退一笔。
     *   示例值：1217752501201407033233368018
     * </pre>
     */
    @ApiModelProperty("商户退款单号")
    private String outRefundNo;

    /**
     * <pre>
     * 字段名：退款原因
     * 变量名：reason
     * 是否必填：是
     * 类型：string（80）
     * 描述：
     *   若商户传入，会在下发给用户的退款消息中体现退款原因。
     *   注意：若订单退款金额≤1元，且属于部分退款，则不会在退款消息中体现退款原因
     *   示例值：商品已售完
     * </pre>
     */
    @ApiModelProperty("退款原因")
    private String reason;

    /**
     * <pre>
     * 字段名：订单金额
     * 变量名：amount
     * 是否必填：是
     * 类型：object
     * 描述：
     *  订单金额信息
     * </pre>
     */
    @ApiModelProperty("订单金额")
    private Amount amount;

    /**
     * <pre>
     * 字段名：退款结果回调url
     * 变量名：notify_url
     * 是否必填：是
     * 类型：string（256）
     * 描述：
     *   异步接收微信支付退款结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。 如果参数中传了notify_url，则商户平台上配置的回调地址将不会生效，优先回调当前传的地址。
     *   示例值：https://weixin.qq.com
     * </pre>
     */
    @ApiModelProperty("退款结果回调url")
    private String notifyUrl;

    @Data
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Amount implements Serializable {
        private static final long serialVersionUID = 7383027142329410399L;

        /**
         * <pre>
         * 字段名：退款金额
         * 变量名：refund
         * 是否必填：是
         * 类型：int
         * 描述：
         *  退款金额，币种的最小单位，只能为整数，不能超过原订单支付金额。
         *  示例值：888
         * </pre>
         */
        @ApiModelProperty("退款金额")
        private Integer refund;

        /**
         * <pre>
         * 字段名：原订单金额
         * 变量名：total
         * 是否必填：是
         * 类型：int64
         * 描述：
         *  订单总金额，单位为分。
         *  示例值：888
         * </pre>
         */
        @ApiModelProperty("原订单金额")
        private Integer total;

        /**
         * <pre>
         * 字段名：币类型
         * 变量名：currency
         * 是否必填：否
         * 类型：string(18)
         * 描述：
         *  符合ISO 4217标准的三位字母代码，目前只支持人民币：CNY。
         *  示例值：CNY
         * </pre>
         */
        @ApiModelProperty("币类型")
        private String currency;

    }


}

