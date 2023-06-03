package org.dows.sdk.weixin.open.dsjglgzh.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/officalaccount-management/qrcode-config/publishJumpQRCode.html
 *
 * @author lait.zhang@gmail.com
 * @description 发布已设置的二维码规则
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "发布已设置的二维码规则Request", title = "发布已设置的二维码规则Request")
public class FaBuYiSheZhiDeErWeiMaGuiZeRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "二维码规则。如果是服务号，则是服务号的带参的二维码url。")
    private String prefix;
}

