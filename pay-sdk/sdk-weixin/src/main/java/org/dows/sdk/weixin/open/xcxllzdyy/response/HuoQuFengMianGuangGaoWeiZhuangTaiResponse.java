package org.dows.sdk.weixin.open.xcxllzdyy.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-mgnt/GetCoverAdposStatus.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取封面广告位状态
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取封面广告位状态Response", title = "获取封面广告位状态Response")
public class HuoQuFengMianGuangGaoWeiZhuangTaiResponse {
    @Schema(title = "错误码")
    private Integer ret;
    @Schema(title = "错误信息")
    private Boolean err_msg;
    @Schema(title = "下次允许开启的封面广告位的时间")
    private Integer next_open_time;
    @Schema(title = "封面广告位开关状态")
    private Integer status;
}

