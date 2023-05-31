package org.dows.sdk.weixin.pay.基础支付.小程序支付.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_5_9.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年5月31日 上午11:18:23
 */
@Data
@Schema(name = "申请退款Request", title = "申请退款Request")
public class 申请退款Request{
    @Schema(title = "")
    private String[1, 32] 微信支付订单号;
    @Schema(title = "")
    private String[1, 64] 商户退款单号;
    @Schema(title = "")
    private String[1, 80] 退款原因;
    @Schema(title = "")
    private String[8, 256] 退款结果回调url;
    @Schema(title = "")
    private String[1,32] 退款资金来源;
    @Schema(title = "")
    private Object ;
    @Schema(title = "退款金额，单位为分，只能为整数，不能超过原订单支付金额。")
    private Int 退款金额;
    @Schema(title = "退款需要从指定账户出资时，传递此参数指定出资金额（币种的最小单位，只能为整数）。")
    private Array ;
    @Schema(title = "下面枚举值多选一。")
    private String[1, 32] 出资账户类型;
    @Schema(title = "对应账户出资金额")
    private Int 出资金额;
    @Schema(title = "原支付交易的订单总金额，单位为分，只能为整数。")
    private Int 原订单金额;
    @Schema(title = "符合ISO 4217标准的三位字母代码，目前只支持人民币：CNY。")
    private String[1, 16] 退款币种;
    @Schema(title = "")
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

