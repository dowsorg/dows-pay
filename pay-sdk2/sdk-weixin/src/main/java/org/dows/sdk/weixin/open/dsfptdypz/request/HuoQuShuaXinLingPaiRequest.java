package org.dows.sdk.weixin.open1.dsfptdypz.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ticket-token/getAuthorizerRefreshToken.html
 * @description 获取刷新令牌
 * @author lait.zhang@gmail.com
 * @date 2023年6月2日 下午4:54:46
 */
@Data
@Schema(name = "获取刷新令牌Request", title = "获取刷新令牌Request")
public class HuoQuShuaXinLingPaiRequest{
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "第三方平台 appid")
    private String component_appid;
    @Schema(title = "授权码, 会在授权成功时返回给第三方平台，详见")
    private String authorization_code;
}

