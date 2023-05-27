package org.dows.sdk.weixin.thirdparty.management.response;

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
