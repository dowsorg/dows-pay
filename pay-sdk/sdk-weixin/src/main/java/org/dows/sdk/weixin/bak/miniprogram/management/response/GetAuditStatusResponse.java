package org.dows.sdk.weixin.bak.miniprogram.management.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/getAuditStatus.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "GetAuditStatusResponse", title = "GetAuditStatusResponse")
public class GetAuditStatusResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "审核状态")
    private Integer status;
    @Schema(title = "当 status = 1 时，返回的拒绝原因; status = 4 时，返回的延后原因")
    private String reason;
    @Schema(title = "当 status = 1 时，会返回审核失败的小程序截图示例。用")
    private String screenshot;
}

