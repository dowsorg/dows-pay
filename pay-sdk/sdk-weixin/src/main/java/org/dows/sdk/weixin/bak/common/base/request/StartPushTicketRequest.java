package org.dows.sdk.weixin.bak.common.base.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ticket-token/startPushTicket.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "StartPushTicketRequest", title = "StartPushTicketRequest")
public class StartPushTicketRequest {
    @Schema(title = "平台型第三方平台的appid")
    private String component_appid;
    @Schema(title = "平台型第三方平台的APPSECRET")
    private String component_secret;
}

