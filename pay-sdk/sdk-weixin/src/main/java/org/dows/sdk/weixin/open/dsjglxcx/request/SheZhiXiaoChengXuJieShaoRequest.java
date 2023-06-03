package org.dows.sdk.weixin.open.dsjglxcx.request;

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
@Schema(name = "设置小程序介绍Request", title = "设置小程序介绍Request")
public class SheZhiXiaoChengXuJieShaoRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "功能介绍（简介）")
    private String signature;
}

