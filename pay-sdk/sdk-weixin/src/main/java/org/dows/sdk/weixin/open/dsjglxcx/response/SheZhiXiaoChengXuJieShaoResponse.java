package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/setSignature.html
 *
 * @author lait.zhang@gmail.com
 * @description 设置小程序介绍
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "设置小程序介绍Response", title = "设置小程序介绍Response")
public class SheZhiXiaoChengXuJieShaoResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

