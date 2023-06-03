package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/member-management/bindTester.html
 *
 * @author lait.zhang@gmail.com
 * @description 绑定体验者
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "绑定体验者Request", title = "绑定体验者Request")
public class BangDingTiYanZheRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "微信号")
    private String wechatid;
}

