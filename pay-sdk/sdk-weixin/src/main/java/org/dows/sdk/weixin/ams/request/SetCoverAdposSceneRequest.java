package org.dows.sdk.weixin.ams.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @description
 * @date
 */
@Data
@NoArgsConstructor
public class SetCoverAdposSceneRequest {
    @Schema(title = "封面广告场景值")
    private String cover_scene_list;

}
