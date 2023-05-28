package org.dows.sdk.weixin.miniprogram.management.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "SetCodeAuditQuotaResponse", title = "SetCodeAuditQuotaResponse")
public class SetCodeAuditQuotaResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "quota剩余值")
    private Integer rest;
    @Schema(title = "当月分配quota")
    private Integer limit;
    @Schema(title = "剩余加急次数")
    private Integer speedup_rest;
    @Schema(title = "当月分配加急次数")
    private Integer speedup_limit;
}

