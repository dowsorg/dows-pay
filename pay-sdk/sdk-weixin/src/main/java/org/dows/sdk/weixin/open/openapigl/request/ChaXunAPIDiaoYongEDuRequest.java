package org.dows.sdk.weixin.open.openapigl.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/openapi/getApiQuota.html
 *
 * @author lait.zhang@gmail.com
 * @description 查询API调用额度
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "查询API调用额度Request", title = "查询API调用额度Request")
public class ChaXunAPIDiaoYongEDuRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "api的请求地址，例如'/cgi-bin/message/custom/send';不要前缀“https://api.weixin.qq.com” ，也不要漏了'/',否则都会76003的报错")
    private String cgi_path;
}

