package org.dows.sdk.weixin.cloudbase.common.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "GetFuntionConfigRequest", title = "GetFuntionConfigRequest")
public class GetFuntionConfigRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "配置类型")
    private Integer type;
    @Schema(title = "环境id")
    private String env;
    @Schema(title = "云函数名")
    private String function_name;
}

