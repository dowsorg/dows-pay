package org.dows.sdk.weixin.open.dsjzcxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/register-management/fast-registration-ent/registerMiniprogram.html
 *
 * @author lait.zhang@gmail.com
 * @description 快速注册企业小程序
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "快速注册企业小程序Response", title = "快速注册企业小程序Response")
public class KuaiSuZhuCeQiYeXiaoChengXuResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

