package org.dows.sdk.weixin.open.dsfptdypz.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ticket-token/getAuthorizerAccessToken.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取授权帐号调用令牌
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取授权帐号调用令牌Request", title = "获取授权帐号调用令牌Request")
public class HuoQuShouQuanZhangHaoDiaoYongLingPaiRequest {
    @Schema(title = "第三方平台接口调用凭证")
    private String component_access_token;
    @Schema(title = "第三方平台 appid")
    private String component_appid;
    @Schema(title = "授权方 appid")
    private String authorizer_appid;
    @Schema(title = "刷新令牌，")
    private String authorizer_refresh_token;
}

