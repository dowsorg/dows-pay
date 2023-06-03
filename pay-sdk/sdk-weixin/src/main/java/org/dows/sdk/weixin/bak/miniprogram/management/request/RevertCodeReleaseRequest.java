package org.dows.sdk.weixin.bak.miniprogram.management.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/revertCodeRelease.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "RevertCodeReleaseRequest", title = "RevertCodeReleaseRequest")
public class RevertCodeReleaseRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "只能填get_history_version。表示获取可回退的小程序版本。该参数为 URL 参数，非 Body 参数。")
    private String action;
    @Schema(title = "默认是回滚到上一个版本；也可回滚到指定的小程序版本，可通过get_history_version获取app_version。该参数为 URL 参数，非 Body 参数。")
    private String app_version;
}

