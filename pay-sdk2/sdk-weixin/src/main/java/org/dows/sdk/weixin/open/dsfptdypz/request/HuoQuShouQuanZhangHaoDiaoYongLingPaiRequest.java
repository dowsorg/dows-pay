package org.dows.sdk.weixin.open.dsfptdypz.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ticket-token/getAuthorizerAccessToken.html
 * @description 获取授权帐号调用令牌
 * @author lait.zhang@gmail.com
 * @date 2023年6月2日 下午4:54:46
 */
@Data
@Schema(name = "获取授权帐号调用令牌Request", title = "获取授权帐号调用令牌Request")
public class HuoQuShouQuanZhangHaoDiaoYongLingPaiRequest{
    @Schema(title = "第三方平台接口调用凭证")
    private String component_access_token;
    @Schema(title = "第三方平台 appid")
    private String component_appid;
    @Schema(title = "授权方 appid")
    private String authorizer_appid;
    @Schema(title = "刷新令牌，")
    private String authorizer_refresh_token;
}

