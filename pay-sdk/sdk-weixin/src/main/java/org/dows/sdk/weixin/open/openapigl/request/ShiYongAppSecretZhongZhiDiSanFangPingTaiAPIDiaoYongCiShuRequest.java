package org.dows.sdk.weixin.open.openapigl.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/openapi/clearComponentQuotaByAppSecret.html
 *
 * @author lait.zhang@gmail.com
 * @description 使用AppSecret重置第三方平台 API 调用次数
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "使用AppSecret重置第三方平台 API 调用次数Request", title = "使用AppSecret重置第三方平台 API 调用次数Request")
public class ShiYongAppSecretZhongZhiDiSanFangPingTaiAPIDiaoYongCiShuRequest {
    @Schema(title = "授权用户appid")
    private String appid;
    @Schema(title = "第三方appid")
    private String component_appid;
    @Schema(title = "第三方appsecret")
    private String appsecret;
}

