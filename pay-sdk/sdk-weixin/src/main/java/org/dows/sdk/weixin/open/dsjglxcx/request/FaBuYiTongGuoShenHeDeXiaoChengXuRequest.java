package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/release.html
 *
 * @author lait.zhang@gmail.com
 * @description 发布已通过审核的小程序
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "发布已通过审核的小程序Request", title = "发布已通过审核的小程序Request")
public class FaBuYiTongGuoShenHeDeXiaoChengXuRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
}

