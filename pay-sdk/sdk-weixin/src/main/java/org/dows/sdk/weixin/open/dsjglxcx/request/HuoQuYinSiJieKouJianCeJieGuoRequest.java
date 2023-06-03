package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/getCodePrivacyInfo.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取隐私接口检测结果
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取隐私接口检测结果Request", title = "获取隐私接口检测结果Request")
public class HuoQuYinSiJieKouJianCeJieGuoRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
}

