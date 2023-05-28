package org.dows.sdk.weixin.miniprogram.management.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "GetLinkForShowRequest", title = "GetLinkForShowRequest")
public class GetLinkForShowRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "页码，从 0 开始")
    private Integer page;
    @Schema(title = "每页记录数，最大为 20")
    private Integer num;
}

