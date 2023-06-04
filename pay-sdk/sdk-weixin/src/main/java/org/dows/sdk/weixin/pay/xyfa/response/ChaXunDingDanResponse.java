package org.dows.sdk.weixin.pay.xyfa.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_8_4.shtml
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年6月3日 上午10:38:52
 */
@Data
@Schema(name = "查询订单Response", title = "查询订单Response")
public class ChaXunDingDanResponse {
    @Schema(title = "appid是商户在微信申请公众号或移动应用成功后分配的账号ID，登录平台为mp.weixin.qq.com或open.weixin.qq.com")
    private String appid;
    @Schema(title = "微信支付分配的商户号")
    private String sp_mchid;
    @Schema(title = "商户自定义字段，用于交易账单中对扣费服务的描述。")
    private String description;
    @Schema(title = "订单成功创建时返回，遵循")
    private String create_time;
    @Schema(title = "商户系统内部订单号，只能是数字、大小写字母，且在同一个商户号下唯一")
    private String out_trade_no;
    @Schema(title = "微信支付订单号")
    private String transaction_id;
    @Schema(title = "枚举值：")
    private String trade_state;
    @Schema(title = "对当前订单状态的描述和下一步操作的指引")
    private String trade_state_description;
    @Schema(title = "订单支付完成时间，遵循")
    private String success_time;
    @Schema(title = "银行类型，采用字符串类型的银行标识。")
    private String bank_type;
    @Schema(title = "枚举值：")
    private String user_repaid;
    @Schema(title = "附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用，实际情况下只有支付完成状态才会返回该字段。")
    private String attach;
    @Schema(title = "交易场景值，目前支持")
    private String trade_scene;
    @Schema(title = "返回信息中的trade_scene为PARKING，返回该场景信息")
    private Object parking_info;
    @Schema(title = "微信支付分停车服务为商户分配的入场id，商户通过入场通知接口获取入场id")
    private String parking_id;
    @Schema(title = "车牌号，仅包括省份+车牌，不包括特殊字符。")
    private String plate_number;
    @Schema(title = "车牌颜色，枚举值：")
    private String plate_color;
    @Schema(title = "用户入场时间，遵循")
    private String start_time;
    @Schema(title = "用户出场时间，遵循")
    private String end_time;
    @Schema(title = "所在停车位车场的名称")
    private String parking_name;
    @Schema(title = "计费的时间长，单位为秒")
    private Integer charging_duration;
    @Schema(title = "停车场设备id")
    private String device_id;
    @Schema(title = "支付者信息")
    private Object payer;
    @Schema(title = "用户在appid下的唯一标识")
    private String openid;
    @Schema(title = "用户在sub_appid下的标识，商户扣费时传入了sub_appid，则会返回该用户在sub_appid下的标识")
    private String sub_openid;
    @Schema(title = "订单金额信息")
    private Object amount;
    @Schema(title = "订单总金额，单位为分，只能为整数")
    private Integer total;
    @Schema(title = "符合ISO 4217标准的三位字母代码，目前只支持人民币：CNY")
    private String currency;
    @Schema(title = "用户实际支付金额，单位为分，只能为整数")
    private Integer payer_total;
    @Schema(title = "订单折扣")
    private Integer discount_total;
    @Schema(title = "优惠信息")
    private List<String> promotion_detail;
    @Schema(title = "券或者立减优惠id")
    private String coupon_id;
    @Schema(title = "优惠名称")
    private String name;
    @Schema(title = "枚举值：")
    private String scope;
    @Schema(title = "枚举值：")
    private String type;
    @Schema(title = "在微信商户后台配置的批次ID")
    private String stock_id;
    @Schema(title = "用户享受优惠的金额")
    private Integer amount1;
    @Schema(title = "特指由微信支付商户平台创建的优惠，出资金额等于本项优惠总金额，单位为分")
    private Integer wechatpay_contribute;
    @Schema(title = "特指商户自己创建的优惠，出资金额等于本项优惠总金额，单位为分")
    private Integer merchant_contribute;
    @Schema(title = "其他出资方出资金额，单位为分")
    private Integer other_contribute;
    @Schema(title = "CNY：人民币，境内商户号仅支持人民币。")
    private String currency1;
}

