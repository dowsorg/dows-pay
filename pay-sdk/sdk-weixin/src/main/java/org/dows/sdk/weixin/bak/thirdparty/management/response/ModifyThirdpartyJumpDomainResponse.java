package org.dows.sdk.weixin.bak.thirdparty.management.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/thirdparty-management/domain-mgnt/modifyThirdpartyJumpDomain.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "ModifyThirdpartyJumpDomainResponse", title = "ModifyThirdpartyJumpDomainResponse")
public class ModifyThirdpartyJumpDomainResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "目前生效的 “全网发布版”第三方平台“小程序业务域名”。如果修改失败，该字段不会返回。如果没有已发布的第三方平台，该字段也不会返回。")
    private String published_wxa_jump_h5_domain;
    @Schema(title = "目前生效的 “测试版”第三方平台“小程序业务域名”。如果修改失败，该字段不会返回")
    private String testing_wxa_jump_h5_domain;
    @Schema(title = "未通过验证的域名。如果不存在未通过验证的域名，该字段不会返回。")
    private String invalid_wxa_jump_h5_domain;
}

