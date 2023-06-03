package org.dows.sdk.weixin.bak.officalaccount.management.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/officalaccount-management/qrcode-config/deleteJumpQRCode.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "DeleteJumpQRCodeRequest", title = "DeleteJumpQRCodeRequest")
public class DeleteJumpQRCodeRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "二维码规则")
    private String prefix;
    @Schema(title = "小程序appid。")
    private String appid;
}

