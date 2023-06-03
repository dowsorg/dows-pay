package org.dows.sdk.weixin.open.dsfptdypz.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ticket-token/startPushTicket.html
 *
 * @author lait.zhang@gmail.com
 * @description 启动票据推送服务
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "启动票据推送服务Request", title = "启动票据推送服务Request")
public class QiDongPiaoJuTuiSongFuWuRequest {
    @Schema(title = "平台型第三方平台的appid")
    private String component_appid;
    @Schema(title = "平台型第三方平台的APPSECRET")
    private String component_secret;
}

