package org.dows.sdk.weixin.open.dsjglxcx.response;

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
@Schema(name = "删除半屏小程序Response", title = "删除半屏小程序Response")
public class ShanChuBanPingXiaoChengXuResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

