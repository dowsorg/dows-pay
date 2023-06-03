package org.dows.sdk.weixin.bak.common.base.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ticket-token/getAuthorizerAccessToken.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "GetAuthorizerAccessTokenResponse", title = "GetAuthorizerAccessTokenResponse")
public class GetAuthorizerAccessTokenResponse {
    @Schema(title = "授权方令牌")
    private String authorizer_access_token;
    @Schema(title = "有效期，单位：秒")
    private Integer expires_in;
    @Schema(title = "刷新令牌")
    private String authorizer_refresh_token;
}

