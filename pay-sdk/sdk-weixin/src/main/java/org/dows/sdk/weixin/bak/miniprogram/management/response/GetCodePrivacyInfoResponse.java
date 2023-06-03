package org.dows.sdk.weixin.bak.miniprogram.management.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/getCodePrivacyInfo.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "GetCodePrivacyInfoResponse", title = "GetCodePrivacyInfoResponse")
public class GetCodePrivacyInfoResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "没权限的隐私接口的api英文名")
    private List<String> without_auth_list;
    @Schema(title = "没配置的隐私接口的api英文名")
    private List<String> without_conf_list;
}

