package org.dows.sdk.weixin.miniprogram.management.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "SetShowItemRequest", title = "SetShowItemRequest")
public class SetShowItemRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "是否打开扫码关注组件，0 关闭，1 开启")
    private Integer wxa_subscribe_biz_flag;
    @Schema(title = "如果开启，需要传新的公众号 appid")
    private String appid;
}

