package org.dows.sdk.weixin.miniprogram.management.response;

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
public class GetCodePrivacyInfoResponse {
    @Schema(title = "错误码")
    private Number errcode;

    @Schema(title = "错误信息")
    private String errmsg;

    @Schema(title = "没权限的隐私接口的api英文名")
    private List<String> without_auth_list;

    @Schema(title = "没配置的隐私接口的api英文名")
    private List<String> without_conf_list;


}
