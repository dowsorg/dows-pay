package org.dows.sdk.weixin.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author
 * @description
 * @date 2023年5月28日 下午9:25:34
 * @date
 */
@Data
public class GetAuthorizerListRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "第三方平台 APPID")
    private String component_appid;
    @Schema(title = "偏移位置/起始位置")
    private Integer offset;
    @Schema(title = "拉取数量，最大为 500")
    private Integer count;
}

