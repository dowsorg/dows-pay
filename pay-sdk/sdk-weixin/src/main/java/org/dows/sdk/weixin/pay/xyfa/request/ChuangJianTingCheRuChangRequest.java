package org.dows.sdk.weixin.pay.xyfa.request;

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
@Schema(name = "创建停车入场Request", title = "创建停车入场Request")
public class ChuangJianTingCheRuChangRequest {
    @Schema(title = "")
    private String out_parking_no;
    @Schema(title = "")
    private String plate_number;
    @Schema(title = "")
    private String plate_color;
    @Schema(title = "")
    private String notify_url;
    @Schema(title = "")
    private String start_time;
    @Schema(title = "")
    private String parking_name;
    @Schema(title = "")
    private Integer free_duration;
}

