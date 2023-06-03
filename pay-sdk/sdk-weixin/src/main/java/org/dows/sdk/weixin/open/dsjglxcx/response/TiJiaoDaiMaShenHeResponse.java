package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/submitAudit.html
 *
 * @author lait.zhang@gmail.com
 * @description 提交代码审核
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "提交代码审核Response", title = "提交代码审核Response")
public class TiJiaoDaiMaShenHeResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "审核编号")
    private Integer auditid;
}

