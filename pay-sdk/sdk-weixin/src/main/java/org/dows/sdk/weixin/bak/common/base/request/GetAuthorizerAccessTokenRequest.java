package org.dows.sdk.weixin.bak.common.base.request;

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
@Schema(name = "GetAuthorizerAccessTokenRequest", title = "GetAuthorizerAccessTokenRequest")
public class GetAuthorizerAccessTokenRequest {
    @Schema(title = "第三方平台接口调用凭证")
    private String component_access_token;
    @Schema(title = "第三方平台 appid")
    private String component_appid;
    @Schema(title = "授权方 appid")
    private String authorizer_appid;
    @Schema(title = "刷新令牌，")
    private String authorizer_refresh_token;
}

