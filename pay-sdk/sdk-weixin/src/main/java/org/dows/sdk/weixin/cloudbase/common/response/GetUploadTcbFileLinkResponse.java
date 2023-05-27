package org.dows.sdk.weixin.cloudbase.common.response;

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
public class GetUploadTcbFileLinkResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "上传url")
    private String url;
    @Schema(title = "token")
    private String token;
    @Schema(title = "authorization")
    private String authorization;
    @Schema(title = "文件ID")
    private String file_id;
    @Schema(title = "cos文件ID")
    private String cos_file_id;

}
