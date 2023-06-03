package org.dows.sdk.weixin.open.dsfptdypz.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ticket-token/getAuthorizerRefreshToken.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取刷新令牌
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取刷新令牌Request", title = "获取刷新令牌Request")
public class HuoQuShuaXinLingPaiRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "第三方平台 appid")
    private String component_appid;
    @Schema(title = "授权码, 会在授权成功时返回给第三方平台，详见")
    private String authorization_code;
}

