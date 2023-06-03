package org.dows.sdk.weixin.open.dsjzcxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/register-management/fast-regist-beta/verfifyBetaMiniprogram.html
 *
 * @author lait.zhang@gmail.com
 * @description 试用小程序快速认证
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "试用小程序快速认证Request", title = "试用小程序快速认证Request")
public class ShiYongXiaoChengXuKuaiSuRenZhengRequest {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

