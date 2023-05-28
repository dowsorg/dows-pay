package org.dows.sdk.weixin.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author
 * @description
 * @date 2023年5月28日 下午9:25:34
 * @date
 */
@Data
public class GetComponentAccessTokenResponse {
    @Schema(title = "第三方平台 access_token")
    private String component_access_token;
    @Schema(title = "有效期，单位：秒")
    private Integer expires_in;
}

