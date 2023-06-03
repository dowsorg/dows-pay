package org.dows.sdk.weixin.open1.dsfptdypz.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ticket-token/getComponentAccessToken.html
 * @description 获取令牌
 * @author lait.zhang@gmail.com
 * @date 2023年6月2日 下午4:54:46
 */
@Data
@Schema(name = "获取令牌Response", title = "获取令牌Response")
public class HuoQuLingPaiResponse{
    @Schema(title = "第三方平台 access_token")
    private String component_access_token;
    @Schema(title = "有效期，单位：秒")
    private Integer expires_in;
}

