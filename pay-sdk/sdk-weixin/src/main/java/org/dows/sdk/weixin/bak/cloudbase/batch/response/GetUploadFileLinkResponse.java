package org.dows.sdk.weixin.bak.cloudbase.batch.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/file-mgnt/getUploadFileLink.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "GetUploadFileLinkResponse", title = "GetUploadFileLinkResponse")
public class GetUploadFileLinkResponse {
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
}

