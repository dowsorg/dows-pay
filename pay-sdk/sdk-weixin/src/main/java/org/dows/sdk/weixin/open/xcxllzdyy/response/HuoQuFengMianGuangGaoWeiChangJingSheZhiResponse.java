package org.dows.sdk.weixin.open.xcxllzdyy.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-mgnt/GetCoverAdposScene.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取封面广告位场景设置
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取封面广告位场景设置Response", title = "获取封面广告位场景设置Response")
public class HuoQuFengMianGuangGaoWeiChangJingSheZhiResponse {
    @Schema(title = "错误码")
    private Integer ret;
    @Schema(title = "错误信息")
    private String err_msg;
    @Schema(title = "封面广告场景值")
    private String scene_list;
}

