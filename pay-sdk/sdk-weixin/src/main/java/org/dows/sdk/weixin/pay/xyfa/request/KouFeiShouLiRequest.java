package org.dows.sdk.weixin.pay.xyfa.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_8_3.shtml
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年6月3日 上午10:38:52
 */
@Data
@Schema(name = "扣费受理Request", title = "扣费受理Request")
public class KouFeiShouLiRequest {
    @Schema(title = "")
    private String appid;
    @Schema(title = "")
    private String description;
    @Schema(title = "")
    private String attach;
    @Schema(title = "")
    private String out_trade_no;
    @Schema(title = "")
    private String trade_scene;
    @Schema(title = "")
    private String goods_tag;
    @Schema(title = "")
    private String notify_url;
    @Schema(title = "")
    private String profit_sharing;
    @Schema(title = "")
    private Object amount;
    @Schema(title = "订单总金额，单位为分，只能为整数")
    private Integer total;
    @Schema(title = "符合ISO 4217标准的三位字母代码，目前只支持人民币：CNY")
    private String currency;
    @Schema(title = "")
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
}

