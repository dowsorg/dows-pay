package org.dows.sdk.weixin.pay.基础支付.Native支付.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_4_1.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年5月31日 下午9:40:07
 */
@Data
@Schema(name = "Native下单Request", title = "Native下单Request")
public class Native下单Request{
    @Schema(title = "")
    private String[1,32] 服务商应用ID;
    @Schema(title = "")
    private String[1,32] 服务商户号;
    @Schema(title = "")
    private String[1,32] 子商户应用ID;
    @Schema(title = "")
    private String[1,32] 子商户号;
    @Schema(title = "")
    private String[1,127] 商品描述;
    @Schema(title = "")
    private String[1,32] 商户订单号;
    @Schema(title = "")
    private String[1,64] 交易结束时间;
    @Schema(title = "")
    private String[1,128] 附加数据;
    @Schema(title = "")
    private String[1,256] 通知地址;
    @Schema(title = "")
    private String[1,32] 订单优惠标记;
    @Schema(title = "")
    private Object ;
    @Schema(title = "是否指定分账，枚举值")
    private Boolean 是否指定分账;
    @Schema(title = "SettleInfo.profit_sharing为true时，该金额才生效。")
    private Int64 补差金额;
    @Schema(title = "")
    private Object ;
    @Schema(title = "订单总金额，单位为分。")
    private Int 总金额;
    @Schema(title = "CNY：人民币，境内商户号仅支持人民币。")
    private String[1,16] 货币类型;
    @Schema(title = "")
    private Object ;
    @Schema(title = "1、商户侧一张小票订单可能被分多次支付，订单原价用于记录整张小票的交易金额。")
    private Int 订单原价;
    @Schema(title = "商家小票ID")
    private String[1,32] 商品小票ID;
    @Schema(title = "单品列表信息")
    private Array ;
    @Schema(title = "由半角的大小写字母、数字、中划线、下划线中的一种或几种组成。")
    private String[1,32] 商户侧商品编码;
    @Schema(title = "微信支付定义的统一商品编号（没有可不传）")
    private String[1,32] 微信侧商品编码;
    @Schema(title = "商品的实际名称")
    private String[1,256] 商品名称;
    @Schema(title = "用户购买的数量")
    private Int 商品数量;
    @Schema(title = "商品单价，单位为分")
    private Int 商品单价;
    @Schema(title = "")
    private Object ;
    @Schema(title = "用户的客户端IP，支持IPv4和IPv6两种格式的IP地址。")
    private String[1,45] 用户终端IP;
    @Schema(title = "商户端设备号（门店号或收银设备ID）。")
    private String[1,32] 商户端设备号;
    @Schema(title = "商户门店信息")
    private Object ;
    @Schema(title = "商户侧门店编号")
    private String[1,32] 门店编号;
    @Schema(title = "商户侧门店名称")
    private String[1,256] 门店名称;
    @Schema(title = "地区编码，详细请见")
    private String[1,32] 地区编码;
    @Schema(title = "详细的商户门店地址")
    private String[1,512] 详细地址;
}

