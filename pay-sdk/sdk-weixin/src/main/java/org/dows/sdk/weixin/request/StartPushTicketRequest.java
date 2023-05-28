package org.dows.sdk.weixin.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;

/**
* @description 
*
* @author 
* @date 
*/
@Data
public class StartPushTicketRequest{
    @Schema(title = "平台型第三方平台的appid")
    private String component_appid;
    @Schema(title = "平台型第三方平台的APPSECRET")
    private String component_secret;
}

