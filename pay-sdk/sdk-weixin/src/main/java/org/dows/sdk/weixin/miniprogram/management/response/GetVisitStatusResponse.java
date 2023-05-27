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
public class GetVisitStatusResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "服务状态。0表示已暂停服务（包含主动暂停服务违规被暂停服务）。1表示未暂停服务。")
    private Integer status;

}
