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
public class GetUploadFuntionConfigRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;

    @Schema(title = "配置类型")
    private Number type;

    @Schema(title = "环境id")
    private String env;

    @Schema(title = "云函数名")
    private String function_name;

    @Schema(title = "配置的json字符串")
    private String config;


}
