package org.dows.sdk.weixin.miniprogram.management.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @description
 * @date
 */
@Data
@NoArgsConstructor
public class WeDataSetLoginConfigRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;

    @Schema(title = "1: 配置反查地址 ; 2:配置关联appid")
    private Number set_type;

    @Schema(title = "反查地址，set_type =1时生效，若为空表示删除")
    private String recheck_url;

    @Schema(title = "关联appid，set_type=2时生效，若为空表示删除")
    private List<String> associate_appid;


}
