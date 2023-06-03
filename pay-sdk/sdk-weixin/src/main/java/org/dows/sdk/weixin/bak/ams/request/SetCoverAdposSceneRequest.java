package org.dows.sdk.weixin.bak.ams.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-mgnt/SetCoverAdposScene.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "SetCoverAdposSceneRequest", title = "SetCoverAdposSceneRequest")
public class SetCoverAdposSceneRequest {
    @Schema(title = "封面广告场景值")
    private String cover_scene_list;
}

