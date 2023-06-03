package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/embedded-management/addEmbedded.html
 *
 * @author lait.zhang@gmail.com
 * @description 添加半屏小程序
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "添加半屏小程序Request", title = "添加半屏小程序Request")
public class TianJiaBanPingXiaoChengXuRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "添加的半屏小程序 appid")
    private String appid;
    @Schema(title = "申请理由，不超过 30 个字")
    private String apply_reason;
}

