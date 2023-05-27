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
public class InvokeCloudFunctionRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "云开发环境ID")
    private String env;
    @Schema(title = "云函数名称")
    private String name;
    @Schema(title = "云函数的传入参数，具体结构由开发者定义")
    private String req_data;

}
