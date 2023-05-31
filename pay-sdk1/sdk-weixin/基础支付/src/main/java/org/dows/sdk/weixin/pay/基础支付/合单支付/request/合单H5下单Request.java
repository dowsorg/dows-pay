package org.dows.sdk.weixin.pay.基础支付.合单支付.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_2.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年5月31日 上午11:18:23
 */
@Data
@Schema(name = "合单H5下单Request", title = "合单H5下单Request")
public class 合单H5下单Request{
    @Schema(title = "")
    private String[1,32] 合单商户appid;
    @Schema(title = "")
    private String[1,32] 合单商户号;
    @Schema(title = "")
    private String[1,32] 合单商户订单号;
    @Schema(title = "")
    private Object ;
    @Schema(title = "终端设备号（门店号或收银设备ID） 。")
    private String[7,16] 商户端设备号;
    @Schema(title = "用户的客户端IP，支持IPv4和IPv6两种格式的IP地址。")
    private String[1,45] 用户终端IP;
    @Schema(title = "H5场景信息")
    private Object ;
    @Schema(title = "场景类型，枚举值：")
    private String[1,32] 场景类型;
    @Schema(title = "应用名称")
    private String[1,64] 应用名称;
    @Schema(title = "网站URL")
    private String[1,128] 网站URL;
    @Schema(title = "iOS平台BundleID")
    private String[1,128] iOS平台BundleID;
    @Schema(title = "Android平台PackageName")
    private String[1,128] Android平台PackageName;
    @Schema(title = "")
    private Array ;
    @Schema(title = "子单发起方商户号即合单参与方商户号，必须与发起方appid有绑定关系。")
    private String[1,32] 子单商户号;
    @Schema(title = "附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用。")
    private String[1,128] 附加数据;
    @Schema(title = "订单金额信息")
    private Object ;
    @Schema(title = "子单金额，单位为分")
    private Int64 标价金额;
    @Schema(title = "符合ISO 4217标准的三位字母代码，人民币：CNY 。")
    private String[1,8] 标价币种;
    @Schema(title = "商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。")
    private String[1,32] 子单商户订单号;
    @Schema(title = "订单优惠标记，使用代金券或立减优惠功能时需要的参数，说明详见")
    private String[1,32] 订单优惠标记;
    @Schema(title = "商品简单描述。需传入应用市场上的APP名字-实际商品名称，例如：天天爱消除-游戏充值。")
    private String[1,127] 商品描述;
    @Schema(title = "结算信息")
    private Object ;
    @Schema(title = "是否分账，枚举值：")
    private Bool 是否指定分账;
    @Schema(title = "SettleInfo.profit_sharing为true时，该金额才生效。")
    private Int64 补差金额;
    @Schema(title = "")
    private String[1,32] 交易起始时间;
    @Schema(title = "")
    private String[1,32] 交易结束时间;
    @Schema(title = "")
    private String[1,256] 通知地址;
}

