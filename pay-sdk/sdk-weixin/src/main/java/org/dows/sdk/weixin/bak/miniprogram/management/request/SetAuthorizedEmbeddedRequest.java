package org.dows.sdk.weixin.bak.miniprogram.management.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/embedded-management/setAuthorizedEmbedded.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "SetAuthorizedEmbeddedRequest", title = "SetAuthorizedEmbeddedRequest")
public class SetAuthorizedEmbeddedRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "半屏小程序授权方式。0表示需要管理员验证；1表示自动通过；2表示自动拒绝。")
    private Integer flag;
}

