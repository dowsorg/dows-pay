package org.dows.sdk.weixin.pay.jczf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_5_2.shtml
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年6月3日 上午10:38:51
 */
@Data
@Schema(name = "查询订单Response", title = "查询订单Response")
public class ChaXunDingDanResponse {
    @Schema(title = "服务商申请的公众号或移动应用appid。")
    private String sp_appid;
    @Schema(title = "服务商户号，由微信支付生成并下发")
    private String sp_mchid;
    @Schema(title = "子商户申请的公众号或移动应用appid。")
    private String sub_appid;
    @Schema(title = "子商户的商户号，有微信支付生成并下发。")
    private String sub_mchid;
    @Schema(title = "商户系统内部订单号，只能是数字、大小写字母_-*且在同一个商户号下唯一，详见【商户订单号】。")
    private String out_trade_no;
    @Schema(title = "微信支付系统生成的订单号。")
    private String transaction_id;
    @Schema(title = "交易类型，枚举值：")
    private String trade_type;
    @Schema(title = "交易状态，枚举值：")
    private String trade_state;
    @Schema(title = "交易状态描述")
    private String trade_state_desc;
    @Schema(title = "银行类型，采用字符串类型的银行标识。 银行标识请参考《")
    private String bank_type;
    @Schema(title = "附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用")
    private String attach;
    @Schema(title = "支付完成时间，遵循")
    private String success_time;
    @Schema(title = "支付者信息")
    private Object payer;
    @Schema(title = "用户在服务商appid下的唯一标识。")
    private String sp_openid;
    @Schema(title = "用户在子商户appid下的唯一标识。")
    private String sub_openid;
    @Schema(title = "订单金额信息，当支付成功时返回该字段。")
    private Object amount;
    @Schema(title = "订单总金额，单位为分。")
    private Integer total;
    @Schema(title = "用户支付金额，单位为分。")
    private Integer payer_total;
    @Schema(title = "CNY：人民币，境内商户号仅支持人民币。")
    private String currency;
    @Schema(title = "用户支付币种")
    private String payer_currency;
    @Schema(title = "支付场景描述")
    private Object scene_info;
    @Schema(title = "商户端设备号（发起扣款请求的商户服务器设备号）。")
    private String device_id;
    @Schema(title = "优惠功能，享受优惠时返回该字段。")
    private List<String> promotion_detail;
    @Schema(title = "券ID")
    private String coupon_id;
    @Schema(title = "优惠名称")
    private String name;
    @Schema(title = "GLOBAL：全场代金券")
    private String scope;
    @Schema(title = "CASH：充值")
    private String type;
    @Schema(title = "优惠券面额")
    private Integer amount1;
    @Schema(title = "活动ID")
    private String stock_id;
    @Schema(title = "微信出资，单位为分")
    private Integer wechatpay_contribute;
    @Schema(title = "商户出资，单位为分")
    private Integer merchant_contribute;
    @Schema(title = "其他出资，单位为分")
    private Integer other_contribute;
    @Schema(title = "CNY：人民币，境内商户号仅支持人民币。")
    private String currency1;
    @Schema(title = "单品列表信息")
    private List<String> goods_detail;
    @Schema(title = "商品编码")
    private String goods_id;
    @Schema(title = "用户购买的数量")
    private Integer quantity;
    @Schema(title = "商品单价，单位为分")
    private Integer unit_price;
    @Schema(title = "商品优惠金额")
    private Integer discount_amount;
    @Schema(title = "商品备注信息")
    private String goods_remark;
}

