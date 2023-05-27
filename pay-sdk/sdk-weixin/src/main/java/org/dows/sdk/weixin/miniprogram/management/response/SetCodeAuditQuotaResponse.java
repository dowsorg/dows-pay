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
public class SetCodeAuditQuotaResponse {
    @Schema(title = "返回码")
    private Number errcode;

    @Schema(title = "错误信息")
    private String errmsg;

    @Schema(title = "quota剩余值")
    private Number rest;

    @Schema(title = "当月分配quota")
    private Number limit;

    @Schema(title = "剩余加急次数")
    private Number speedup_rest;

    @Schema(title = "当月分配加急次数")
    private Number speedup_limit;


}
