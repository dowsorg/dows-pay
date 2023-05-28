package org.dows.sdk.weixin.ams.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "SetCoverAdposSceneRequest", title = "SetCoverAdposSceneRequest")
public class SetCoverAdposSceneRequest {
    @Schema(title = "封面广告场景值")
    private String cover_scene_list;
}

