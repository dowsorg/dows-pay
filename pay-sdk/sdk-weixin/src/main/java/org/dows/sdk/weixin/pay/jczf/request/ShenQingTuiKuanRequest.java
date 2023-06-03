package org.dows.sdk.weixin.pay.jczf.request;

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
@Schema(name = "申请退款Request", title = "申请退款Request")
public class ShenQingTuiKuanRequest {
    @Schema(title = "")
    private String transaction_id;
    @Schema(title = "")
    private String out_refund_no;
    @Schema(title = "")
    private String reason;
    @Schema(title = "")
    private String notify_url;
    @Schema(title = "")
    private String funds_account;
    @Schema(title = "")
    private Object amount;
    @Schema(title = "退款金额，单位为分，只能为整数，不能超过原订单支付金额。")
    private Integer refund;
    @Schema(title = "退款需要从指定账户出资时，传递此参数指定出资金额（币种的最小单位，只能为整数）。")
    private List<String> from;
    @Schema(title = "下面枚举值多选一。")
    private String account;
    @Schema(title = "对应账户出资金额")
    private Integer amount1;
    @Schema(title = "原支付交易的订单总金额，单位为分，只能为整数。")
    private Integer total;
    @Schema(title = "符合ISO 4217标准的三位字母代码，目前只支持人民币：CNY。")
    private String currency;
    @Schema(title = "")
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
    private Integer refund_amount;
    @Schema(title = "单品的退款数量")
    private Integer refund_quantity;
}

