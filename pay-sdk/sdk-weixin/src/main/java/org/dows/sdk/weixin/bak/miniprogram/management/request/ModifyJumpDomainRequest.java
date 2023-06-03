package org.dows.sdk.weixin.bak.miniprogram.management.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/domain-management/modifyJumpDomain.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "ModifyJumpDomainRequest", title = "ModifyJumpDomainRequest")
public class ModifyJumpDomainRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "操作类型，如果没有指定 action，则默认将第三方平台登记的小程序业务域名全部添加到该小程序")
    private String action;
    @Schema(title = "小程序业务域名，当 action 参数是 get 时不需要此字段")
    private List<String> webviewdomain;
}

