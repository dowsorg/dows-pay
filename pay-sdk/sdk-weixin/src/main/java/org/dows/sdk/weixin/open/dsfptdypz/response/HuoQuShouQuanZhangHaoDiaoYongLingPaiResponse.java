package org.dows.sdk.weixin.open.dsfptdypz.response;

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
@Schema(name = "获取授权帐号调用令牌Response", title = "获取授权帐号调用令牌Response")
public class HuoQuShouQuanZhangHaoDiaoYongLingPaiResponse {
    @Schema(title = "授权方令牌")
    private String authorizer_access_token;
    @Schema(title = "有效期，单位：秒")
    private Integer expires_in;
    @Schema(title = "刷新令牌")
    private String authorizer_refresh_token;
}

