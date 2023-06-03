package org.dows.sdk.weixin.pay.xyfa.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_8_2.shtml
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年6月3日 上午10:38:52
 */
@Data
@Schema(name = "创建停车入场Response", title = "创建停车入场Response")
public class ChuangJianTingCheRuChangResponse {
    @Schema(title = "车主服务为商户分配的入场id")
    private String id;
    @Schema(title = "商户侧入场标识id，在同一个商户号下唯一")
    private String out_parking_no;
    @Schema(title = "车牌号，仅包括省份+车牌，不包括特殊字符。")
    private String plate_number;
    @Schema(title = "车牌颜色，枚举值：")
    private String plate_color;
    @Schema(title = "入场时间，遵循")
    private String start_time;
    @Schema(title = "所在停车位车场的名称")
    private String parking_name;
    @Schema(title = "停车场的免费停车时长，单位为秒")
    private Integer free_duration;
    @Schema(title = "本次入场车牌的服务状态，")
    private String state;
    @Schema(title = "block服务状态描述，返回车牌状态为BLOCKED，会返回该字段，描述具体BLOCKED的原因，")
    private String block_reason;
}

