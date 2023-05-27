package org.dows.sdk.weixin.miniprogram.management.request;

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
public class GetTrialQRCodeRequest {
    @Schema(title = "第三方平台接口调用凭证")
    private String access_token;
    @Schema(title = "指定二维码扫码后直接进入指定页面并可同时带上参数")
    private String path;

}
