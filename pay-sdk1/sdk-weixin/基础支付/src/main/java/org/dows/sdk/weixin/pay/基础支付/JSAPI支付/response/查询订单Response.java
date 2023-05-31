package org.dows.sdk.weixin.pay.基础支付.JSAPI支付.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_1_2.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年5月31日 下午2:46:10
 */
@Data
@Schema(name = "查询订单Response", title = "查询订单Response")
public class 查询订单Response{
    @Schema(title = "服务商申请的公众号或移动应用appid。")
    private String[1,32] 服务商应用ID;
    @Schema(title = "服务商户号，由微信支付生成并下发")
    private String[1,32] 服务商户号;
    @Schema(title = "子商户申请的公众号或移动应用appid。")
    private String[1,32] 子商户应用ID;
    @Schema(title = "子商户的商户号，有微信支付生成并下发。")
    private String[1,32] 子商户号;
    @Schema(title = "商户系统内部订单号，只能是数字、大小写字母_-*且在同一个商户号下唯一，详见【商户订单号】。")
    private String[1,32] 商户订单号;
    @Schema(title = "微信支付系统生成的订单号。")
    private String[1,32] 微信支付订单号;
    @Schema(title = "交易类型，枚举值：")
    private String[1,16] 交易类型;
    @Schema(title = "交易状态，枚举值：")
    private String[1,32] 交易状态;
    @Schema(title = "交易状态描述")
    private String[1,256] 交易状态描述;
    @Schema(title = "银行类型，采用字符串类型的银行标识。 银行标识请参考《")
    private String[1,16] 付款银行;
    @Schema(title = "附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用")
    private String[1,128] 附加数据;
    @Schema(title = "支付完成时间，遵循")
    private String[1,64] 支付完成时间;
    @Schema(title = "支付者信息")
    private Object ;
    @Schema(title = "用户在服务商appid下的唯一标识。")
    private String[1,128] 用户服务标识;
    @Schema(title = "用户在子商户appid下的唯一标识。")
    private String[1,128] 用户子标识;
    @Schema(title = "订单金额信息，当支付成功时返回该字段。")
    private Object ;
    @Schema(title = "订单总金额，单位为分。")
    private Int 总金额;
    @Schema(title = "用户支付金额，单位为分。")
    private Int 用户支付金额;
    @Schema(title = "CNY：人民币，境内商户号仅支持人民币。")
    private String[1,16] 货币类型;
    @Schema(title = "用户支付币种")
    private String[1,16] 用户支付币种;
    @Schema(title = "支付场景描述")
    private Object ;
    @Schema(title = "商户端设备号（发起扣款请求的商户服务器设备号）。")
    private String[1,32] 商户端设备号;
    @Schema(title = "优惠功能，享受优惠时返回该字段。")
    private Array ;
    @Schema(title = "券ID")
    private String[1,32] 券ID;
    @Schema(title = "优惠名称")
    private String[1,64] 优惠名称;
    @Schema(title = "GLOBAL：全场代金券")
    private String[1,32] 优惠范围;
    @Schema(title = "CASH：充值")
    private String[1,32] 优惠类型;
    @Schema(title = "优惠券面额")
    private Int 优惠券面额;
    @Schema(title = "活动ID")
    private String[1,32] 活动ID;
    @Schema(title = "微信出资，单位为分")
    private Int 微信出资;
    @Schema(title = "商户出资，单位为分")
    private Int 商户出资;
    @Schema(title = "其他出资，单位为分")
    private Int 其他出资;
    @Schema(title = "CNY：人民币，境内商户号仅支持人民币。")
    private String[1,16] 优惠币种;
    @Schema(title = "单品列表信息")
    private Array ;
    @Schema(title = "商品编码")
    private String[1,32] 商品编码;
    @Schema(title = "用户购买的数量")
    private Int 商品数量;
    @Schema(title = "商品单价，单位为分")
    private Int 商品单价;
    @Schema(title = "商品优惠金额")
    private Int 商品优惠金额;
    @Schema(title = "商品备注信息")
    private String[1,128] 商品备注;
}

