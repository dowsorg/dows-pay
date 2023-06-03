package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/getTrialQRCode.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取体验版二维码
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取体验版二维码Response", title = "获取体验版二维码Response")
public class HuoQuTiYanBanErWeiMaResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

