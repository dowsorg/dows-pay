package org.dows.sdk.weixin.bak.miniprogram.management.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/login/thirdpartyCode2Session.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "ThirdpartyCode2SessionResponse", title = "ThirdpartyCode2SessionResponse")
public class ThirdpartyCode2SessionResponse {
    @Schema(title = "会话密钥")
    private String session_key;
    @Schema(title = "用户唯一标识的 openid")
    private String openid;
    @Schema(title = "用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回，详见")
    private String unionid;
}

