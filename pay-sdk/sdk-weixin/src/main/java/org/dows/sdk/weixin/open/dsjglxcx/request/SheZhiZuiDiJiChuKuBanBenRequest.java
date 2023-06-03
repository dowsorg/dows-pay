package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/setSupportVersion.html
 *
 * @author lait.zhang@gmail.com
 * @description 设置最低基础库版本
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "设置最低基础库版本Request", title = "设置最低基础库版本Request")
public class SheZhiZuiDiJiChuKuBanBenRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "为已发布的基础库版本号")
    private String version;
}

