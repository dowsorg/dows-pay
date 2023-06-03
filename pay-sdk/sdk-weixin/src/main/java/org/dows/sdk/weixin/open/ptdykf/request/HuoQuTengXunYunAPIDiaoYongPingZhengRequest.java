package org.dows.sdk.weixin.open.ptdykf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/admin-management/getCloudToken.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取腾讯云API调用凭证
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取腾讯云API调用凭证Request", title = "获取腾讯云API调用凭证Request")
public class HuoQuTengXunYunAPIDiaoYongPingZhengRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "有效期（单位为秒，最大7200）")
    private Integer lifespan;
}

