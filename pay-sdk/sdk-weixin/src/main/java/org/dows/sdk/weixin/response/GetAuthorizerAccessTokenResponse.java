package org.dows.sdk.weixin.response;

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
@Schema(name = "GetAuthorizerAccessTokenResponse", title = "GetAuthorizerAccessTokenResponse")
public class GetAuthorizerAccessTokenResponse{
    @Schema(title = "授权方令牌")
    private String authorizer_access_token;
    @Schema(title = "有效期，单位：秒")
    private Integer expires_in;
    @Schema(title = "刷新令牌")
    private String authorizer_refresh_token;
}

