package org.dows.sdk.weixin.bak.ams.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-mgnt/GetCoverAdposScene.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "GetCoverAdposSceneResponse", title = "GetCoverAdposSceneResponse")
public class GetCoverAdposSceneResponse {
    @Schema(title = "错误码")
    private Integer ret;
    @Schema(title = "错误信息")
    private String err_msg;
    @Schema(title = "封面广告场景值")
    private String scene_list;
}

