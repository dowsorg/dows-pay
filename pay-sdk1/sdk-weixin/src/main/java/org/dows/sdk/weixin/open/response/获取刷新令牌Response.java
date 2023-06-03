package org.dows.sdk.weixin.open1.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis//doc/oplatform/openApi/OpenApiDoc/ticket-token/getAuthorizerRefreshToken.html
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年6月2日 下午2:52:10
 */
@Data
@Schema(name = "获取刷新令牌Response", title = "获取刷新令牌Response")
public class 获取刷新令牌Response{
}

