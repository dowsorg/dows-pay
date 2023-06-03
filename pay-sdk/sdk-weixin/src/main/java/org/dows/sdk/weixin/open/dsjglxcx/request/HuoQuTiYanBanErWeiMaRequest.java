package org.dows.sdk.weixin.open.dsjglxcx.request;

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
@Schema(name = "获取体验版二维码Request", title = "获取体验版二维码Request")
public class HuoQuTiYanBanErWeiMaRequest {
    @Schema(title = "第三方平台接口调用凭证")
    private String access_token;
    @Schema(title = "指定二维码扫码后直接进入指定页面并可同时带上参数")
    private String path;
}

