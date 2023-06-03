package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/grayRelease.html
 *
 * @author lait.zhang@gmail.com
 * @description 分阶段发布
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "分阶段发布Request", title = "分阶段发布Request")
public class FenJieDuanFaBuRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "灰度的百分比 0~ 100 的整。如果gray_percentage=0，support_experiencer_first与support_debuger_first二选一必填")
    private Integer gray_percentage;
    @Schema(title = "true表示支持按体验成员灰度，默认是false")
    private Boolean support_debuger_first;
    @Schema(title = "true表示支持按项目成员灰度，默认是false")
    private Boolean support_experiencer_first;
}

