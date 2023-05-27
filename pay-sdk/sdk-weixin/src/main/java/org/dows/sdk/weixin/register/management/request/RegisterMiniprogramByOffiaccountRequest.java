package org.dows.sdk.weixin.register.management.request;

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
public class RegisterMiniprogramByOffiaccountRequest {
    @Schema(title = "第三方平台接口调用凭证")
    private String access_token;
    @Schema(title = "公众号扫码授权的凭证(公众平台扫码页面回跳到第三方平台时携带)，要看")
    private String ticket;

}
