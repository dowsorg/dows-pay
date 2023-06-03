package org.dows.sdk.weixin.open.dsjglxcx.response;

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
@Schema(name = "小程序登录Response", title = "小程序登录Response")
public class XiaoChengXuDengLuResponse {
    @Schema(title = "会话密钥")
    private String session_key;
    @Schema(title = "用户唯一标识的 openid")
    private String openid;
    @Schema(title = "用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回，详见")
    private String unionid;
}

