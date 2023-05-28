package org.dows.sdk.weixin.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author
 * @description
 * @date 2023年5月28日 下午9:25:34
 * @date
 */
@Data
public class ClearComponentQuotaByAppSecretRequest {
    @Schema(title = "授权用户appid")
    private String appid;
    @Schema(title = "第三方appid")
    private String component_appid;
    @Schema(title = "第三方appsecret")
    private String appsecret;
}

