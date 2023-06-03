package org.dows.sdk.weixin.bak.register.management.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/register-management/fast-registration-officalaccount/registerMiniprogramByOffiaccount.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "RegisterMiniprogramByOffiaccountRequest", title = "RegisterMiniprogramByOffiaccountRequest")
public class RegisterMiniprogramByOffiaccountRequest {
    @Schema(title = "第三方平台接口调用凭证")
    private String access_token;
    @Schema(title = "公众号扫码授权的凭证(公众平台扫码页面回跳到第三方平台时携带)，要看")
    private String ticket;
}

