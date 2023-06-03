package org.dows.sdk.weixin.open.dsfptdypz.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ticket-token/getPreAuthCode.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取预授权码
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取预授权码Request", title = "获取预授权码Request")
public class HuoQuYuShouQuanMaRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "第三方平台 appid")
    private String component_appid;
}

