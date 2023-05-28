package org.dows.sdk.weixin.ams.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author
 * @description
 * @date 2023年5月28日 下午9:25:34
 * @date
 */
@Data
public class SetCoverAdposSceneRequest {
    @Schema(title = "封面广告场景值")
    private String cover_scene_list;
}

