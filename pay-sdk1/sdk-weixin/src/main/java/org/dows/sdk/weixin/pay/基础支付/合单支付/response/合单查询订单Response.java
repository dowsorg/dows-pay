package org.dows.sdk.weixin.pay.基础支付.合单支付.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_11.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年5月31日 下午9:40:07
 */
@Data
@Schema(name = "合单查询订单Response", title = "合单查询订单Response")
public class 合单查询订单Response{
    @Schema(title = "合单发起方的appid。")
    private String[1,32] 合单商户appid;
    @Schema(title = "合单发起方商户号。")
    private String[1,32] 合单商户号;
    @Schema(title = "合单支付总订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。")
    private String[1,32] 合单商户订单号;
    @Schema(title = "支付场景信息描述")
    private Object ;
    @Schema(title = "终端设备号（门店号或收银设备ID） 。")
    private String[7,16] 商户端设备号;
    @Schema(title = "最多支持子单条数：10")
    private Array ;
    @Schema(title = "子单发起方商户号，必须与发起方Appid有绑定关系。")
    private String[1,32] 子单商户号;
    @Schema(title = "枚举值：")
    private String[1,16] 交易类型;
    @Schema(title = "枚举值：")
    private String[1,32] 交易状态;
    @Schema(title = "银行类型，采用字符串类型的银行标识。")
    private String[1,32] 付款银行;
    @Schema(title = "附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用。")
    private String[1,128] 附加数据;
    @Schema(title = "订单支付时间，遵循")
    private String[1,32] 支付完成时间;
    @Schema(title = "微信支付订单号。")
    private String[1,32] 微信订单号;
    @Schema(title = "商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。")
    private String[6,32] 子单商户订单号;
    @Schema(title = "优惠功能，子单有核销优惠券时有返回")
    private Array ;
    @Schema(title = "券ID")
    private String[1, 32] 券ID;
    @Schema(title = "优惠名称")
    private String[1, 64] 优惠名称;
    @Schema(title = "GLOBAL：全场代金券")
    private String[1, 32] 优惠范围;
    @Schema(title = "CASH：充值型代金券")
    private String[1,8] 优惠类型;
    @Schema(title = "当前子单中享受的优惠券金额")
    private Int 优惠券金额;
    @Schema(title = "活动ID，批次ID")
    private String[1, 32] 活动ID;
    @Schema(title = "单位为分")
    private Int 微信出资;
    @Schema(title = "单位为分")
    private Int 商户出资;
    @Schema(title = "单位为分")
    private Int 其他出资;
    @Schema(title = "CNY：人民币，境内商户号仅支持人民币。")
    private String[1,16] 优惠币种;
    @Schema(title = "单品列表")
    private Array ;
    @Schema(title = "商品编码")
    private String[1, 32] 商品编码;
    @Schema(title = "商品数量")
    private Int 商品数量;
    @Schema(title = "商品价格")
    private Int 商品价格;
    @Schema(title = "商品优惠金额")
    private Int 商品优惠金额;
    @Schema(title = "商品备注")
    private String[1, 128] 商品备注;
    @Schema(title = "订单金额信息")
    private Object ;
    @Schema(title = "子单金额，单位为分。")
    private Int64 标价金额;
    @Schema(title = "符合ISO 4217标准的三位字母代码，人民币：CNY。")
    private String[1,16] 标价币种;
    @Schema(title = "订单现金支付金额。")
    private Int64 现金支付金额;
    @Schema(title = "货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY。")
    private String[1,8] 现金支付币种;
    @Schema(title = "支付者信息")
    private Object ;
    @Schema(title = "使用合单appid获取的对应用户openid。是用户在商户appid下的唯一标识。")
    private String[1,128] 用户标识;
}

