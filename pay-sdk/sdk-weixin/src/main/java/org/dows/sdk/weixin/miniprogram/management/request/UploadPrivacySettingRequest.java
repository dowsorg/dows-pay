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
public class UploadPrivacySettingRequest {
    @Schema(title = "第三方平台接口调用凭证")
    private String access_token;

    @Schema(title = "只支持传txt文件")
    private Bufffer file;


}
