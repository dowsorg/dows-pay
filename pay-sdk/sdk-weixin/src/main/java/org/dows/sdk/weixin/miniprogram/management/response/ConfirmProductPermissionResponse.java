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
public class ConfirmProductPermissionResponse {
    @Schema(title = "错误码")
    private Number errcode;

    @Schema(title = "错误原因")
    private String errmsg;

    @Schema(title = "最近一次审核的结果")
    private String last_result;


}
