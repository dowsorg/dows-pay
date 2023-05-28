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
public class StartPushTicketRequest {
    @Schema(title = "平台型第三方平台的appid")
    private String component_appid;
    @Schema(title = "平台型第三方平台的APPSECRET")
    private String component_secret;
}

