package org.dows.sdk.weixin.open.pldykf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/staticstore-management/getUploadStaticStoreFile.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取上传静态网站文件链接
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取上传静态网站文件链接Response", title = "获取上传静态网站文件链接Response")
public class HuoQuShangChuanJingTaiWangZhanWenJianLianJieResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "上传链接")
    private String signed_url;
    @Schema(title = "x-cos-security-token的值")
    private String token;
}

