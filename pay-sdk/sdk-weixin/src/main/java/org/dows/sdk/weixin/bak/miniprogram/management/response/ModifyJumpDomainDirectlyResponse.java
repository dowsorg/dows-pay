package org.dows.sdk.weixin.bak.miniprogram.management.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/domain-management/modifyJumpDomainDirectly.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "ModifyJumpDomainDirectlyResponse", title = "ModifyJumpDomainDirectlyResponse")
public class ModifyJumpDomainDirectlyResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "业务域名")
    private List<String> webviewdomain;
}

