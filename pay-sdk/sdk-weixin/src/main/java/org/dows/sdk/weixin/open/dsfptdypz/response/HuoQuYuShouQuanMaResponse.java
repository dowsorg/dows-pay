package org.dows.sdk.weixin.open.dsfptdypz.response;

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
@Schema(name = "获取预授权码Response", title = "获取预授权码Response")
public class HuoQuYuShouQuanMaResponse {
    @Schema(title = "预授权码")
    private String pre_auth_code;
    @Schema(title = "有效期，单位：秒")
    private Integer expires_in;
}

