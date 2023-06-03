package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/login/thirdpartyCode2Session.html
 *
 * @author lait.zhang@gmail.com
 * @description 小程序登录
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "小程序登录Request", title = "小程序登录Request")
public class XiaoChengXuDengLuRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String component_access_token;
    @Schema(title = "小程序的 AppID")
    private String appid;
    @Schema(title = "填 authorization_code")
    private String grant_type;
    @Schema(title = "第三方平台 appid")
    private String component_appid;
    @Schema(title = "")
    private String js_code;
}

