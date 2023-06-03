package org.dows.sdk.weixin.open1.dsfptdypz.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ticket-token/startPushTicket.html
 * @description 启动票据推送服务
 * @author lait.zhang@gmail.com
 * @date 2023年6月2日 下午4:54:46
 */
@Data
@Schema(name = "启动票据推送服务Request", title = "启动票据推送服务Request")
public class QiDongPiaoJuTuiSongFuWuRequest{
    @Schema(title = "平台型第三方平台的appid")
    private String component_appid;
    @Schema(title = "平台型第三方平台的APPSECRET")
    private String component_secret;
}

