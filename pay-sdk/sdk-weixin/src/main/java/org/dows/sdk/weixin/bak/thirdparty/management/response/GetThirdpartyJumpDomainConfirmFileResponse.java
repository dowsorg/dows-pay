package org.dows.sdk.weixin.bak.thirdparty.management.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/thirdparty-management/domain-mgnt/getThirdpartyJumpDomainConfirmFile.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "GetThirdpartyJumpDomainConfirmFileResponse", title = "GetThirdpartyJumpDomainConfirmFileResponse")
public class GetThirdpartyJumpDomainConfirmFileResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "文件名")
    private String file_name;
    @Schema(title = "文件内容")
    private String file_content;
}

