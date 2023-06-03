package org.dows.sdk.weixin.pay.jczf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_14.shtml
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年6月3日 上午10:38:51
 */
@Data
@Schema(name = "申请退款Response", title = "申请退款Response")
public class ShenQingTuiKuanResponse {
    @Schema(title = "微信支付退款单号")
    private String refund_id;
    @Schema(title = "商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。")
    private String out_refund_no;
    @Schema(title = "微信支付交易订单号")
    private String transaction_id;
    @Schema(title = "原支付交易对应的商户订单号")
    private String out_trade_no;
    @Schema(title = "枚举值：")
    private String channel;
    @Schema(title = "取当前退款单的退款入账方，有以下几种情况：")
    private String user_received_account;
    @Schema(title = "退款成功时间，当退款状态为退款成功时有返回。")
    private String success_time;
    @Schema(title = "退款受理时间")
    private String create_time;
    @Schema(title = "退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败，可前往")
    private String status;
    @Schema(title = "退款所使用资金对应的资金账户类型")
    private String funds_account;
    @Schema(title = "金额详细信息")
    private Object amount;
    @Schema(title = "订单总金额，单位为分")
    private Integer total;
    @Schema(title = "退款标价金额，单位为分，可以做部分退款")
    private Integer refund;
    @Schema(title = "退款出资的账户类型及金额信息")
    private List<String> from;
    @Schema(title = "下面枚举值多选一。")
    private String account;
    @Schema(title = "对应账户出资金额")
    private Integer amount0;
    @Schema(title = "现金支付金额，单位为分，只能为整数")
    private Integer payer_total;
    @Schema(title = "退款给用户的金额，不包含所有优惠券金额")
    private Integer payer_refund;
    @Schema(title = "去掉非充值代金券退款金额后的退款金额，单位为分，退款金额=申请退款金额-非充值代金券退款金额，退款金额<=申请退款金额")
    private Integer settlement_refund;
    @Schema(title = "应结订单金额=订单金额-免充值代金券金额，应结订单金额<=订单金额，单位为分")
    private Integer settlement_total;
    @Schema(title = "优惠退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金，说明详见代金券或立减优惠，单位为分")
    private Integer discount_refund;
    @Schema(title = "符合ISO 4217标准的三位字母代码，目前只支持人民币：CNY。")
    private String currency;
    @Schema(title = "手续费退款金额，单位为分。")
    private Integer refund_fee;
    @Schema(title = "优惠退款信息")
    private List<String> promotion_detail;
    @Schema(title = "券或者立减优惠id")
    private String promotion_id;
    @Schema(title = "枚举值：")
    private String scope;
    @Schema(title = "枚举值：")
    private String type;
    @Schema(title = "用户享受优惠的金额（优惠券面额=微信出资金额+商家出资金额+其他出资方金额 ），单位为分")
    private Integer amount1;
    @Schema(title = "优惠退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为用户支付的现金，说明详见代金券或立减优惠，单位为分")
    private Integer refund_amount;
    @Schema(title = "优惠商品发生退款时返回商品信息")
    private List<String> goods_detail;
    @Schema(title = "由半角的大小写字母、数字、中划线、下划线中的一种或几种组成")
    private String merchant_goods_id;
    @Schema(title = "微信支付定义的统一商品编号（没有可不传）")
    private String wechatpay_goods_id;
    @Schema(title = "商品的实际名称")
    private String goods_name;
    @Schema(title = "商品单价金额，单位为分")
    private Integer unit_price;
    @Schema(title = "商品退款金额，单位为分")
    private Integer refund_amount1;
    @Schema(title = "单品的退款数量")
    private Integer refund_quantity;
}

