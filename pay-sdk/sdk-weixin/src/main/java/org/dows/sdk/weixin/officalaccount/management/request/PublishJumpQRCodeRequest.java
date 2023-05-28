package org.dows.sdk.weixin.officalaccount.management.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author
 * @description
 * @date 2023年5月28日 下午9:25:34
 * @date
 */
@Data
public class PublishJumpQRCodeRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "二维码规则。如果是服务号，则是服务号的带参的二维码url。")
    private String prefix;
}

