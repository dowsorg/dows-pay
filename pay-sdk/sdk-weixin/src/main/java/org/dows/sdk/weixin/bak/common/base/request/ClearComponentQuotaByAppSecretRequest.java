package org.dows.sdk.weixin.bak.common.base.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/openapi/clearComponentQuotaByAppSecret.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "ClearComponentQuotaByAppSecretRequest", title = "ClearComponentQuotaByAppSecretRequest")
public class ClearComponentQuotaByAppSecretRequest {
    @Schema(title = "授权用户appid")
    private String appid;
    @Schema(title = "第三方appid")
    private String component_appid;
    @Schema(title = "第三方appsecret")
    private String appsecret;
}

