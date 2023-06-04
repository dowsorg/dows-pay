package org.dows.sdk.weixin.pay.jczf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_11.shtml
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年6月3日 上午10:38:51
 */
@Data
@Schema(name = "合单查询订单Response", title = "合单查询订单Response")
public class HeDanChaXunDingDanResponse {
    @Schema(title = "合单发起方的appid。")
    private String combine_appid;
    @Schema(title = "合单发起方商户号。")
    private String combine_mchid;
    @Schema(title = "合单支付总订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。")
    private String combine_out_trade_no;
    @Schema(title = "支付场景信息描述")
    private Object scene_info;
    @Schema(title = "终端设备号（门店号或收银设备ID） 。")
    private String device_id;
    @Schema(title = "最多支持子单条数：10")
    private List<String> sub_orders;
    @Schema(title = "子单发起方商户号，必须与发起方Appid有绑定关系。")
    private String mchid;
    @Schema(title = "枚举值：")
    private String trade_type;
    @Schema(title = "枚举值：")
    private String trade_state;
    @Schema(title = "银行类型，采用字符串类型的银行标识。")
    private String bank_type;
    @Schema(title = "附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用。")
    private String attach;
    @Schema(title = "订单支付时间，遵循")
    private String success_time;
    @Schema(title = "微信支付订单号。")
    private String transaction_id;
    @Schema(title = "商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。")
    private String out_trade_no;
    @Schema(title = "优惠功能，子单有核销优惠券时有返回")
    private List<String> promotion_detail;
    @Schema(title = "券ID")
    private String coupon_id;
    @Schema(title = "优惠名称")
    private String name;
    @Schema(title = "GLOBAL：全场代金券")
    private String scope;
    @Schema(title = "CASH：充值型代金券")
    private String type;
    @Schema(title = "当前子单中享受的优惠券金额")
    private Integer amount;
    @Schema(title = "活动ID，批次ID")
    private String stock_id;
    @Schema(title = "单位为分")
    private Integer wechatpay_contribute;
    @Schema(title = "单位为分")
    private Integer merchant_contribute;
    @Schema(title = "单位为分")
    private Integer other_contribute;
    @Schema(title = "CNY：人民币，境内商户号仅支持人民币。")
    private String currency;
    @Schema(title = "单品列表")
    private List<String> goods_detail;
    @Schema(title = "商品编码")
    private String goods_id;
    @Schema(title = "商品数量")
    private Integer quantity;
    @Schema(title = "商品价格")
    private Integer unit_price;
    @Schema(title = "商品优惠金额")
    private Integer discount_amount;
    @Schema(title = "商品备注")
    private String goods_remark;
    @Schema(title = "订单金额信息")
    private Object amount1;
    @Schema(title = "子单金额，单位为分。")
    private Integer total_amount;
    @Schema(title = "符合ISO 4217标准的三位字母代码，人民币：CNY。")
    private String currency1;
    @Schema(title = "订单现金支付金额。")
    private Integer payer_amount;
    @Schema(title = "货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY。")
    private String payer_currency;
    @Schema(title = "支付者信息")
    private Object combine_payer_info;
    @Schema(title = "使用合单appid获取的对应用户openid。是用户在商户appid下的唯一标识。")
    private String openid;
}

