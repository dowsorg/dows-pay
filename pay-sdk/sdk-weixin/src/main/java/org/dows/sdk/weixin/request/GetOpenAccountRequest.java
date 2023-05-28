package org.dows.sdk.weixin.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "GetOpenAccountRequest", title = "GetOpenAccountRequest")
public class GetOpenAccountRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "非必填，如果不填则取生成authorizer_access_token的授权公众号或小程序的 appid。如果填，则需要填与生成authorizer_access_token的授权公众号或小程序的 appid一致的appid，否则会出现40013报错。")
    private String appid;
}

