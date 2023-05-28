package org.dows.sdk.weixin.cloudrun.batch.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "GetWxCloudBaseRunEnvsRequest", title = "GetWxCloudBaseRunEnvsRequest")
public class GetWxCloudBaseRunEnvsRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
}

