package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/speedupCodeAudit.html
 *
 * @author lait.zhang@gmail.com
 * @description 加急代码审核
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "加急代码审核Request", title = "加急代码审核Request")
public class JiaJiDaiMaShenHeRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "审核单ID")
    private Integer auditid;
}

