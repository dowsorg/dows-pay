package org.dows.sdk.weixin.miniprogram.management.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.Buffer;

/**
 * @author
 * @description
 * @date
 */
@Data
@NoArgsConstructor
public class UploadMediaToCodeAuditResponse {
    @Schema(title = "错误码")
    private Number errcode;

    @Schema(title = "错误信息")
    private String errmsg;

    @Schema(title = "类型")
    private String type;

    @Schema(title = "媒体id")
    private Buffer mediaid;


}
