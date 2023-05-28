package org.dows.sdk.weixin.cloudbase.batch.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "GetUploadStaticStoreFileResponse", title = "GetUploadStaticStoreFileResponse")
public class GetUploadStaticStoreFileResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "上传链接")
    private String signed_url;
    @Schema(title = "x-cos-security-token的值")
    private String token;
}

