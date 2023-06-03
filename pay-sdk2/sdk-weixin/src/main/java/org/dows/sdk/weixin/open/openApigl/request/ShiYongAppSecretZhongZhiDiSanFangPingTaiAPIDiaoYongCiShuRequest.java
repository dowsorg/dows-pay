package org.dows.sdk.weixin.open1.openApigl.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/openapi/clearComponentQuotaByAppSecret.html
 * @description 使用AppSecret重置第三方平台 API 调用次数
 * @author lait.zhang@gmail.com
 * @date 2023年6月2日 下午4:54:46
 */
@Data
@Schema(name = "使用AppSecret重置第三方平台 API 调用次数Request", title = "使用AppSecret重置第三方平台 API 调用次数Request")
public class ShiYongAppSecretZhongZhiDiSanFangPingTaiAPIDiaoYongCiShuRequest{
    @Schema(title = "授权用户appid")
    private String appid;
    @Schema(title = "第三方appid")
    private String component_appid;
    @Schema(title = "第三方appsecret")
    private String appsecret;
}

