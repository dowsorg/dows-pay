package org.dows.sdk.weixin.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author
 * @description
 * @date 2023年5月28日 下午9:25:34
 * @date
 */
@Data
public class GetAuthorizerAccessTokenResponse {
    @Schema(title = "授权方令牌")
    private String authorizer_access_token;
    @Schema(title = "有效期，单位：秒")
    private Integer expires_in;
    @Schema(title = "刷新令牌")
    private String authorizer_refresh_token;
}

