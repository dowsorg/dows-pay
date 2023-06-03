package org.dows.sdk.weixin.bak.cloudbase.common.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/scf-management/getUploadFuntionConfig.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "GetUploadFuntionConfigRequest", title = "GetUploadFuntionConfigRequest")
public class GetUploadFuntionConfigRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "配置类型")
    private Integer type;
    @Schema(title = "环境id")
    private String env;
    @Schema(title = "云函数名")
    private String function_name;
    @Schema(title = "配置的json字符串")
    private String config;
}

