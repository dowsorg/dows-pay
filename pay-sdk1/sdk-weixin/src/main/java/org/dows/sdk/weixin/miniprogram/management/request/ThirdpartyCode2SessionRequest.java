package org.dows.sdk.weixin.miniprogram.management.request;

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
public class ThirdpartyCode2SessionRequest{
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String component_access_token;
    @Schema(title = "小程序的 AppID")
    private String appid;
    @Schema(title = "填 authorization_code")
    private String grant_type;
    @Schema(title = "第三方平台 appid")
    private String component_appid;
    @Schema(title = "")
    private String js_code;
}

