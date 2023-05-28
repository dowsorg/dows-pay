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
public class Wedata_loginRequest{
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "服务商session，用户访问服务商系统的session")
    private String user_session;
    @Schema(title = "用户在服务商系统的唯一标识，可以是手机号、邮箱、员工ID等等")
    private String uid;
    @Schema(title = "用户的外网ip")
    private String client_ip;
    @Schema(title = "用户的user_agent")
    private String user_agent;
}

