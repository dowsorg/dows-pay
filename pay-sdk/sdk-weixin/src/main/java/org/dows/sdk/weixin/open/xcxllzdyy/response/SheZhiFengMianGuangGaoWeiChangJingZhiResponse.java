package org.dows.sdk.weixin.open.xcxllzdyy.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-mgnt/SetCoverAdposScene.html
 *
 * @author lait.zhang@gmail.com
 * @description 设置封面广告位场景值
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "设置封面广告位场景值Response", title = "设置封面广告位场景值Response")
public class SheZhiFengMianGuangGaoWeiChangJingZhiResponse {
    @Schema(title = "错误码")
    private Integer ret;
    @Schema(title = "错误信息")
    private String err_msg;
}

