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
public class SubmitAuditResponse {
    @Schema(title = "返回码")
    private Number errcode;

    @Schema(title = "错误信息")
    private String errmsg;

    @Schema(title = "审核编号")
    private Number auditid;


}
