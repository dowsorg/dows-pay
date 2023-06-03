package org.dows.sdk.weixin.open1.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis//doc/oplatform/openApi/OpenApiDoc/ticket-token/startPushTicket.html
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年6月2日 下午2:52:10
 */
@Data
@Schema(name = "启动票据推送服务Request", title = "启动票据推送服务Request")
public class 启动票据推送服务Request{
}

