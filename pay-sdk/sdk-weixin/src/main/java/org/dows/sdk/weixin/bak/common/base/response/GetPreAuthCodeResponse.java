package org.dows.sdk.weixin.bak.common.base.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ticket-token/getPreAuthCode.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "GetPreAuthCodeResponse", title = "GetPreAuthCodeResponse")
public class GetPreAuthCodeResponse {
    @Schema(title = "预授权码")
    private String pre_auth_code;
    @Schema(title = "有效期，单位：秒")
    private Integer expires_in;
}

