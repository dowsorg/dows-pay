package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/live-player/applyLivelnfo.html
 *
 * @author lait.zhang@gmail.com
 * @description 申请开通直播
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "申请开通直播Request", title = "申请开通直播Request")
public class ShenQingKaiTongZhiBoRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "填：“apply”")
    private String action;
}

