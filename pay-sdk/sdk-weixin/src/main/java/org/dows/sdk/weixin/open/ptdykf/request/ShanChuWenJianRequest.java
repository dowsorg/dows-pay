package org.dows.sdk.weixin.open.ptdykf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/file-management/deleteTcbCloudFile.html
 *
 * @author lait.zhang@gmail.com
 * @description 删除文件
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "删除文件Request", title = "删除文件Request")
public class ShanChuWenJianRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "云环境ID")
    private String env;
    @Schema(title = "文件 ID 列表")
    private List<String> fileid_list;
}

