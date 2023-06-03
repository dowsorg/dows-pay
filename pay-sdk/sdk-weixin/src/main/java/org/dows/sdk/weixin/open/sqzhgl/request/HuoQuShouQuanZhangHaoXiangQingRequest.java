package org.dows.sdk.weixin.open.sqzhgl.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/authorization-management/getAuthorizerInfo.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取授权帐号详情
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取授权帐号详情Request", title = "获取授权帐号详情Request")
public class HuoQuShouQuanZhangHaoXiangQingRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "第三方平台 appid")
    private String component_appid;
    @Schema(title = "授权的公众号或者小程序的appid")
    private String authorizer_appid;
}

