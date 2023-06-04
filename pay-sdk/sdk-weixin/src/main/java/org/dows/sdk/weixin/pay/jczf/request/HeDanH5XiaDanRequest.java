package org.dows.sdk.weixin.pay.jczf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_2.shtml
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年6月3日 上午10:38:51
 */
@Data
@Schema(name = "合单H5下单Request", title = "合单H5下单Request")
public class HeDanH5XiaDanRequest {
    @Schema(title = "")
    private String combine_appid;
    @Schema(title = "")
    private String combine_mchid;
    @Schema(title = "")
    private String combine_out_trade_no;
    @Schema(title = "")
    private Object scene_info;
    @Schema(title = "终端设备号（门店号或收银设备ID） 。")
    private String device_id;
    @Schema(title = "用户的客户端IP，支持IPv4和IPv6两种格式的IP地址。")
    private String payer_client_ip;
    @Schema(title = "H5场景信息")
    private Object h5_info;
    @Schema(title = "场景类型，枚举值：")
    private String type;
    @Schema(title = "应用名称")
    private String app_name;
    @Schema(title = "网站URL")
    private String app_url;
    @Schema(title = "iOS平台BundleID")
    private String bundle_id;
    @Schema(title = "Android平台PackageName")
    private String package_name;
    @Schema(title = "")
    private List<String> sub_orders;
    @Schema(title = "子单发起方商户号即合单参与方商户号，必须与发起方appid有绑定关系。")
    private String mchid;
    @Schema(title = "附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用。")
    private String attach;
    @Schema(title = "订单金额信息")
    private Object amount;
    @Schema(title = "子单金额，单位为分")
    private Integer total_amount;
    @Schema(title = "符合ISO 4217标准的三位字母代码，人民币：CNY 。")
    private String currency;
    @Schema(title = "商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。")
    private String out_trade_no;
    @Schema(title = "订单优惠标记，使用代金券或立减优惠功能时需要的参数，说明详见")
    private String goods_tag;
    @Schema(title = "商品简单描述。需传入应用市场上的APP名字-实际商品名称，例如：天天爱消除-游戏充值。")
    private String description;
    @Schema(title = "结算信息")
    private Object settle_info;
    @Schema(title = "是否分账，枚举值：")
    private Boolean profit_sharing;
    @Schema(title = "SettleInfo.profit_sharing为true时，该金额才生效。")
    private Integer subsidy_amount;
    @Schema(title = "")
    private String time_start;
    @Schema(title = "")
    private String time_expire;
    @Schema(title = "")
    private String notify_url;
}

