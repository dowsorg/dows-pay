package org.dows.sdk.weixin.open.pldykf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/scf-mgnt/deleteCloudFunction.html
 *
 * @author lait.zhang@gmail.com
 * @description 删除云函数
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "删除云函数Request", title = "删除云函数Request")
public class ShanChuYunHanShuRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "环境名")
    private String functionname;
    @Schema(title = "环境ID")
    private String env;
}

