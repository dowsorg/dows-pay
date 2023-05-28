package org.dows.sdk.weixin.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;

/**
 *
 * @description 
 * @author @author lait.zhang@gmail.com
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "GetComponentAccessTokenRequest", title = "GetComponentAccessTokenRequest")
public class GetComponentAccessTokenRequest{
    @Schema(title = "第三方平台 appid")
    private String component_appid;
    @Schema(title = "第三方平台 appsecret")
    private String component_appsecret;
    @Schema(title = "微信后台推送的")
    private String component_verify_ticket;
}

