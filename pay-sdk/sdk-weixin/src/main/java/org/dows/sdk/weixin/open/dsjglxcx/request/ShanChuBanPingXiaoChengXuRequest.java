package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/embedded-management/deleteEmbedded.html
 *
 * @author lait.zhang@gmail.com
 * @description 删除半屏小程序
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "删除半屏小程序Request", title = "删除半屏小程序Request")
public class ShanChuBanPingXiaoChengXuRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "已添加的半屏小程序appid")
    private String appid;
}

