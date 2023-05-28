package org.dows.sdk.weixin.register.management.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author
 * @description
 * @date 2023年5月28日 下午9:25:34
 * @date
 */
@Data
public class FastRegisterPersonalMpRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "个人用户名字")
    private String idname;
    @Schema(title = "个人用户微信号")
    private String wxuser;
    @Schema(title = "第三方联系电话")
    private String component_phone;
}

