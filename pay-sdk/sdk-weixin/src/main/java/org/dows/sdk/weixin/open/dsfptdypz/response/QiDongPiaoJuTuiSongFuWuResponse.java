package org.dows.sdk.weixin.open.dsfptdypz.response;

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
@Schema(name = "启动票据推送服务Response", title = "启动票据推送服务Response")
public class QiDongPiaoJuTuiSongFuWuResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

