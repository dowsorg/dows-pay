package org.dows.sdk.weixin.open.pldykf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/file-mgnt/getUploadFileLink.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取上传文件链接
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取上传文件链接Response", title = "获取上传文件链接Response")
public class HuoQuShangChuanWenJianLianJieResponse {
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

