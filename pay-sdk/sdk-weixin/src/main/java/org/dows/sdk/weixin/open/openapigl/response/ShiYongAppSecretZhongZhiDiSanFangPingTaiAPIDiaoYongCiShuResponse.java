package org.dows.sdk.weixin.open.openapigl.response;

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
@Schema(name = "使用AppSecret重置第三方平台 API 调用次数Response", title = "使用AppSecret重置第三方平台 API 调用次数Response")
public class ShiYongAppSecretZhongZhiDiSanFangPingTaiAPIDiaoYongCiShuResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

