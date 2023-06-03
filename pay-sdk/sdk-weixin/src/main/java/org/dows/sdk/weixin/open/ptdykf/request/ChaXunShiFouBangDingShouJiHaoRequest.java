package org.dows.sdk.weixin.open.ptdykf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/admin-management/checkMobileConfig.html
 *
 * @author lait.zhang@gmail.com
 * @description 查询是否绑定手机号
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "查询是否绑定手机号Request", title = "查询是否绑定手机号Request")
public class ChaXunShiFouBangDingShouJiHaoRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "是否在小程序未绑定手机号时推送模版消息给管理员收集手机号")
    private Boolean push_tmpl;
}

