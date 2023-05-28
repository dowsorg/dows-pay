package org.dows.sdk.weixin.miniprogram.management.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.nio.Buffer;

/**
 * @author
 * @description
 * @date 2023年5月28日 下午9:25:34
 * @date
 */
@Data
public class UploadMediaToCodeAuditResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "类型")
    private String type;
    @Schema(title = "媒体id")
    private Buffer mediaid;
}

