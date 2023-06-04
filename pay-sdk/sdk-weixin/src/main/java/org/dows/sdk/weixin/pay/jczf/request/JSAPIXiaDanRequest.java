package org.dows.sdk.weixin.pay.jczf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_5_1.shtml
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年6月3日 上午10:38:51
 */
@Data
@Schema(name = "JSAPI下单Request", title = "JSAPI下单Request")
public class JSAPIXiaDanRequest {
    @Schema(title = "")
    private String sp_appid;
    @Schema(title = "")
    private String sp_mchid;
    @Schema(title = "")
    private String sub_appid;
    @Schema(title = "")
    private String sub_mchid;
    @Schema(title = "")
    private String description;
    @Schema(title = "")
    private String out_trade_no;
    @Schema(title = "")
    private String time_expire;
    @Schema(title = "")
    private String attach;
    @Schema(title = "")
    private String notify_url;
    @Schema(title = "")
    private String goods_tag;
    @Schema(title = "")
    private Object settle_info;
    @Schema(title = "是否指定分账，枚举值")
    private Boolean profit_sharing;
    @Schema(title = "SettleInfo.profit_sharing为true时，该金额才生效。")
    private Integer subsidy_amount;
    @Schema(title = "")
    private Object amount;
    @Schema(title = "订单总金额，单位为分。")
    private Integer total;
    @Schema(title = "CNY：人民币，境内商户号仅支持人民币。")
    private String currency;
    @Schema(title = "")
    private Object payer;
    @Schema(title = "用户在服务商appid下的唯一标识。")
    private String sp_openid;
    @Schema(title = "用户在子商户appid下的唯一标识。")
    private String sub_openid;
    @Schema(title = "")
    private Object detail;
    @Schema(title = "1、商户侧一张小票订单可能被分多次支付，订单原价用于记录整张小票的交易金额。")
    private Integer cost_price;
    @Schema(title = "商家小票ID")
    private String invoice_id;
    @Schema(title = "单品列表信息")
    private List<String> goods_detail;
    @Schema(title = "由半角的大小写字母、数字、中划线、下划线中的一种或几种组成。")
    private String merchant_goods_id;
    @Schema(title = "微信支付定义的统一商品编号（没有可不传）")
    private String wechatpay_goods_id;
    @Schema(title = "商品的实际名称")
    private String goods_name;
    @Schema(title = "用户购买的数量")
    private Integer quantity;
    @Schema(title = "商品单价，单位为分")
    private Integer unit_price;
    @Schema(title = "")
    private Object scene_info;
    @Schema(title = "用户的客户端IP，支持IPv4和IPv6两种格式的IP地址。")
    private String payer_client_ip;
    @Schema(title = "商户端设备号（门店号或收银设备ID）。")
    private String device_id;
    @Schema(title = "商户门店信息")
    private Object store_info;
    @Schema(title = "商户侧门店编号")
    private String id;
    @Schema(title = "商户侧门店名称")
    private String name;
    @Schema(title = "地区编码，详细请见")
    private String area_code;
    @Schema(title = "详细的商户门店地址")
    private String address;
}

