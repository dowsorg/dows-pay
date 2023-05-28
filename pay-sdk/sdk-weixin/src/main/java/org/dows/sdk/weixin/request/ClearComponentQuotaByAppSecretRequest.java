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
public class ClearComponentQuotaByAppSecretRequest{
    @Schema(title = "授权用户appid")
    private String appid;
    @Schema(title = "第三方appid")
    private String component_appid;
    @Schema(title = "第三方appsecret")
    private String appsecret;
}

