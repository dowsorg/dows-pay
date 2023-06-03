package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/member-management/getTester.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取体验者列表
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取体验者列表Request", title = "获取体验者列表Request")
public class HuoQuTiYanZheLieBiaoRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "填 'get_experiencer' 即可")
    private String action;
}

