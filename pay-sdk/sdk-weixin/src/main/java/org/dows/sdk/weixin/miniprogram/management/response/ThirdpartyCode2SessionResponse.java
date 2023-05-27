package org.dows.sdk.weixin.miniprogram.management.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @description
 * @date
 */
@Data
@NoArgsConstructor
public class ThirdpartyCode2SessionResponse {
    @Schema(title = "会话密钥")
    private String session_key;
    @Schema(title = "用户唯一标识的 openid")
    private String openid;
    @Schema(title = "用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回，详见")
    private String unionid;

}
