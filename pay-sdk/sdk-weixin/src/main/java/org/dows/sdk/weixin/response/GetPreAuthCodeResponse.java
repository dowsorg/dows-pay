package org.dows.sdk.weixin.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "GetPreAuthCodeResponse", title = "GetPreAuthCodeResponse")
public class GetPreAuthCodeResponse {
    @Schema(title = "预授权码")
    private String pre_auth_code;
    @Schema(title = "有效期，单位：秒")
    private Integer expires_in;
}

