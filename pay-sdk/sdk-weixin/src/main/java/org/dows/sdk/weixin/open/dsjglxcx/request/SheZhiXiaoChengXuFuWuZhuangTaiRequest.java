package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/setVisitStatus.html
 *
 * @author lait.zhang@gmail.com
 * @description 设置小程序服务状态
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "设置小程序服务状态Request", title = "设置小程序服务状态Request")
public class SheZhiXiaoChengXuFuWuZhuangTaiRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "设置可访问状态，发布后默认可访问，close 为不可见，open 为可见")
    private String action;
}

