package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/jumpqrcode-config/publishJumpQRCode.html
 *
 * @author lait.zhang@gmail.com
 * @description 发布已设置的二维码规则
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "发布已设置的二维码规则Response", title = "发布已设置的二维码规则Response")
public class FaBuYiSheZhiDeErWeiMaGuiZeResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

