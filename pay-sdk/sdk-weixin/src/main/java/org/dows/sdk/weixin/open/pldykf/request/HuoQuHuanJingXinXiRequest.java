package org.dows.sdk.weixin.open.pldykf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/env-mgnt/getTcbEnvList.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取环境信息
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取环境信息Request", title = "获取环境信息Request")
public class HuoQuHuanJingXinXiRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
}

