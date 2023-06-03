package org.dows.sdk.weixin.open.ptdykf.response;

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
@Schema(name = "开通云开发Response", title = "开通云开发Response")
public class KaiTongYunKaiFaResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

