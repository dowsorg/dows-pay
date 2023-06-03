package org.dows.sdk.weixin.bak.miniprogram.management.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/domain-management/getEffectiveJumpDomain.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "GetEffectiveJumpDomainResponse", title = "GetEffectiveJumpDomainResponse")
public class GetEffectiveJumpDomainResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "通过公众平台配置的服务器域名列表")
    private List<String> mp_webviewdomain;
    @Schema(title = "通过第三方平台接口")
    private List<String> third_webviewdomain;
    @Schema(title = "通过")
    private List<String> direct_webviewdomain;
    @Schema(title = "最后提交代码或者发布上线后生效的域名列表")
    private List<String> effective_webviewdomain;
}

