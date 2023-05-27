package org.dows.sdk.weixin.cloudbase.common.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @description
 * @date
 */
@Data
@NoArgsConstructor
public class CreateFunctionRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "环境id")
    private String env;
    @Schema(title = "云函数名")
    private String function_name;

}
