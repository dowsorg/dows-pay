package org.dows.sdk.weixin.bak.cloudbase.common.response;

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
@Schema(name = "InvokeCloudFunctionResponse", title = "InvokeCloudFunctionResponse")
public class InvokeCloudFunctionResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "云函数返回的buffer")
    private String resp_data;
}

