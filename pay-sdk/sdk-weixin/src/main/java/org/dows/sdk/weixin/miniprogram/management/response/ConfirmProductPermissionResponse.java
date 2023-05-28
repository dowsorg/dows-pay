package org.dows.sdk.weixin.miniprogram.management.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "ConfirmProductPermissionResponse", title = "ConfirmProductPermissionResponse")
public class ConfirmProductPermissionResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误原因")
    private String errmsg;
    @Schema(title = "最近一次审核的结果")
    private String last_result;
}

