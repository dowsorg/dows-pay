package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/revertCodeRelease.html
 *
 * @author lait.zhang@gmail.com
 * @description 小程序版本回退
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "小程序版本回退Request", title = "小程序版本回退Request")
public class XiaoChengXuBanBenHuiTuiRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "只能填get_history_version。表示获取可回退的小程序版本。该参数为 URL 参数，非 Body 参数。")
    private String action;
    @Schema(title = "默认是回滚到上一个版本；也可回滚到指定的小程序版本，可通过get_history_version获取app_version。该参数为 URL 参数，非 Body 参数。")
    private String app_version;
}

