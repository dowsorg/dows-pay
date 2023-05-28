package org.dows.sdk.weixin.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "GetComponentAccessTokenRequest", title = "GetComponentAccessTokenRequest")
public class GetComponentAccessTokenRequest {
    @Schema(title = "第三方平台 appid")
    private String component_appid;
    @Schema(title = "第三方平台 appsecret")
    private String component_appsecret;
    @Schema(title = "微信后台推送的")
    private String component_verify_ticket;
}

