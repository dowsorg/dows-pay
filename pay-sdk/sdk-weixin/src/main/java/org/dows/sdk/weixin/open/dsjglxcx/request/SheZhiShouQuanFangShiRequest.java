package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/embedded-management/setAuthorizedEmbedded.html
 *
 * @author lait.zhang@gmail.com
 * @description 设置授权方式
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "设置授权方式Request", title = "设置授权方式Request")
public class SheZhiShouQuanFangShiRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "半屏小程序授权方式。0表示需要管理员验证；1表示自动通过；2表示自动拒绝。")
    private Integer flag;
}

