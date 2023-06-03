package org.dows.sdk.weixin.open.ptdykf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/env-management/getEnvInfo.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取云环境
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取云环境Request", title = "获取云环境Request")
public class HuoQuYunHuanJingRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "环境id，如果传了这个参数则只返回该环境的相关信息")
    private String env;
}

