package org.dows.sdk.weixin.bak.common.base.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/openapi/getApiQuota.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "GetApiQuotaRequest", title = "GetApiQuotaRequest")
public class GetApiQuotaRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "api的请求地址，例如'/cgi-bin/message/custom/send';不要前缀“https://api.weixin.qq.com” ，也不要漏了'/',否则都会76003的报错")
    private String cgi_path;
}

