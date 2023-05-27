package org.dows.sdk.weixin.response;

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
public class GetOpenAccountResponse {
    @Schema(title = "公众号或小程序所绑定的开放平台帐号的 appid")
    private String open_appid;

    @Schema(title = "错误码")
    private Number errcode;

    @Schema(title = "错误信息")
    private String errmsg;


}
