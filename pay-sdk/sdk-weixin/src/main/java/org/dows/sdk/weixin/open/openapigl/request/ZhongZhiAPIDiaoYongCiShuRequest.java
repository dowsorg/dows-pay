package org.dows.sdk.weixin.open.openapigl.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/openapi/clearQuota.html
 *
 * @author lait.zhang@gmail.com
 * @description 重置API调用次数
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "重置API调用次数Request", title = "重置API调用次数Request")
public class ZhongZhiAPIDiaoYongCiShuRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "要被清空的账号的appid")
    private String appid;
}

