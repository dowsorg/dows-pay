package org.dows.sdk.weixin.open.pldykf.request;

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
@Schema(name = "获取上传静态网站文件链接Request", title = "获取上传静态网站文件链接Request")
public class HuoQuShangChuanJingTaiWangZhanWenJianLianJieRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "环境ID")
    private String env;
    @Schema(title = "上传文件路径")
    private String filename;
}

