package org.dows.sdk.weixin.open.ptdykf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/admin-management/createCloudUser.html
 *
 * @author lait.zhang@gmail.com
 * @description 开通云开发
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "开通云开发Request", title = "开通云开发Request")
public class KaiTongYunKaiFaRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
}

