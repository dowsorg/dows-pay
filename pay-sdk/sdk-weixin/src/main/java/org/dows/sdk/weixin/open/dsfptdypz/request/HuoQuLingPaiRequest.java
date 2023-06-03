package org.dows.sdk.weixin.open.dsfptdypz.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ticket-token/getComponentAccessToken.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取令牌
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取令牌Request", title = "获取令牌Request")
public class HuoQuLingPaiRequest {
    @Schema(title = "第三方平台 appid")
    private String component_appid;
    @Schema(title = "第三方平台 appsecret")
    private String component_appsecret;
    @Schema(title = "微信后台推送的")
    private String component_verify_ticket;
}

