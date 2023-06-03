package org.dows.sdk.weixin.open.dsfptdypz.response;

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
@Schema(name = "获取令牌Response", title = "获取令牌Response")
public class HuoQuLingPaiResponse {
    @Schema(title = "第三方平台 access_token")
    private String component_access_token;
    @Schema(title = "有效期，单位：秒")
    private Integer expires_in;
}

