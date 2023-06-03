package org.dows.sdk.weixin.open.openapigl.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/openapi/getRidInfo.html
 *
 * @author lait.zhang@gmail.com
 * @description 查询rid信息
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "查询rid信息Request", title = "查询rid信息Request")
public class ChaXunridXinXiRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "调用接口报错返回的rid")
    private String rid;
}

