package org.dows.sdk.weixin.response;

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
public class GetComponentAccessTokenResponse{
    @Schema(title = "第三方平台 access_token")
    private String component_access_token;
    @Schema(title = "有效期，单位：秒")
    private Integer expires_in;
}

