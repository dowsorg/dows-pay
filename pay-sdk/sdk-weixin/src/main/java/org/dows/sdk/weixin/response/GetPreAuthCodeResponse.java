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
public class GetPreAuthCodeResponse{
    @Schema(title = "预授权码")
    private String pre_auth_code;
    @Schema(title = "有效期，单位：秒")
    private Integer expires_in;
}

