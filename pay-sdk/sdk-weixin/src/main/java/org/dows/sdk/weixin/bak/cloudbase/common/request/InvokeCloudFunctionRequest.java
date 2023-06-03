package org.dows.sdk.weixin.bak.cloudbase.common.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/scf-management/invokeCloudFunction.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "InvokeCloudFunctionRequest", title = "InvokeCloudFunctionRequest")
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

