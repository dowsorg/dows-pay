package org.dows.sdk.weixin.pay.基础支付.Native支付.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_4_10.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年5月31日 下午9:40:07
 */
@Data
@Schema(name = "查询单笔退款Response", title = "查询单笔退款Response")
public class 查询单笔退款Response{
    @Schema(title = "微信支付退款单号")
    private String[1, 32] 微信支付退款单号;
    @Schema(title = "商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。")
    private String[1, 64] 商户退款单号;
    @Schema(title = "微信支付交易订单号")
    private String[1, 32] 微信支付订单号;
    @Schema(title = "原支付交易对应的商户订单号")
    private String[1, 32] 商户订单号;
    @Schema(title = "枚举值：")
    private String[1, 16] 退款渠道;
    @Schema(title = "取当前退款单的退款入账方，有以下几种情况：")
    private String[1, 64] 退款入账账户;
    @Schema(title = "退款成功时间，当退款状态为退款成功时有返回。")
    private String[1, 64] 退款成功时间;
    @Schema(title = "退款受理时间")
    private String[1, 64] 退款创建时间;
    @Schema(title = "款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败，可前往")
    private String[1, 32] 退款状态;
    @Schema(title = "退款所使用资金对应的资金账户类型")
    private String[1, 32] 资金账户;
    @Schema(title = "金额详细信息")
    private Object ;
    @Schema(title = "订单总金额，单位为分")
    private Int 订单金额;
    @Schema(title = "退款标价金额，单位为分，可以做部分退款")
    private Int 退款金额;
    @Schema(title = "退款出资的账户类型及金额信息")
    private Array ;
    @Schema(title = "下面枚举值多选一。")
    private String[1, 32] 出资账户类型;
    @Schema(title = "对应账户出资金额")
    private Int 出资金额;
    @Schema(title = "现金支付金额，单位为分，只能为整数")
    private Int 用户支付金额;
    @Schema(title = "退款给用户的金额，不包含所有优惠券金额")
    private Int 用户退款金额;
    @Schema(title = "去掉非充值代金券退款金额后的退款金额，单位为分，退款金额=申请退款金额-非充值代金券退款金额，退款金额<=申请退款金额")
    private Int 应结退款金额;
    @Schema(title = "应结订单金额=订单金额-免充值代金券金额，应结订单金额<=订单金额，单位为分")
    private Int 应结订单金额;
    @Schema(title = "优惠退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金，说明详见代金券或立减优惠，单位为分")
    private Int 优惠退款金额;
    @Schema(title = "符合ISO 4217标准的三位字母代码，目前只支持人民币：CNY。")
    private String[1, 16] 退款币种;
    @Schema(title = "手续费退款金额，单位为分。")
    private Int 手续费退款金额;
    @Schema(title = "优惠退款信息")
    private Array ;
    @Schema(title = "券或者立减优惠id")
    private String[1, 32] 券ID;
    @Schema(title = "枚举值：")
    private String[1, 32] 优惠范围;
    @Schema(title = "枚举值：")
    private String[1, 32] 优惠类型;
    @Schema(title = "用户享受优惠的金额（优惠券面额=微信出资金额+商家出资金额+其他出资方金额 ），单位为分")
    private Int 优惠券面额;
    @Schema(title = "优惠退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为用户支付的现金，说明详见代金券或立减优惠，单位为分")
    private Int 优惠退款金额;
    @Schema(title = "优惠商品发生退款时返回商品信息")
    private Array ;
    @Schema(title = "由半角的大小写字母、数字、中划线、下划线中的一种或几种组成")
    private String[1, 32] 商户侧商品编码;
    @Schema(title = "微信支付定义的统一商品编号（没有可不传）")
    private String[1, 32] 微信支付商品编码;
    @Schema(title = "商品的实际名称")
    private String[1, 256] 商品名称;
    @Schema(title = "商品单价金额，单位为分")
    private Int 商品单价;
    @Schema(title = "商品退款金额，单位为分")
    private Int 商品退款金额;
    @Schema(title = "单品的退款数量")
    private Int 商品退货数量;
}

