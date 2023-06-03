package org.dows.sdk.weixin.bak.miniprogram.management.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/grayRelease.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "GrayReleaseRequest", title = "GrayReleaseRequest")
public class GrayReleaseRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "灰度的百分比 0~ 100 的整。如果gray_percentage=0，support_experiencer_first与support_debuger_first二选一必填")
    private Integer gray_percentage;
    @Schema(title = "true表示支持按体验成员灰度，默认是false")
    private Boolean support_debuger_first;
    @Schema(title = "true表示支持按项目成员灰度，默认是false")
    private Boolean support_experiencer_first;
}

