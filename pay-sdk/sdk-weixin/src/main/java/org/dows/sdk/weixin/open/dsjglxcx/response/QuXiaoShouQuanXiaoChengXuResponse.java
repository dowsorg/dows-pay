package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/embedded-management/deleteAuthorizedEmbedded.html
 *
 * @author lait.zhang@gmail.com
 * @description 取消授权小程序
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "取消授权小程序Response", title = "取消授权小程序Response")
public class QuXiaoShouQuanXiaoChengXuResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

