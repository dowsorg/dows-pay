package org.dows.sdk.weixin.open.pldykf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/db-mgnt/dbExport.html
 *
 * @author lait.zhang@gmail.com
 * @description 数据库导出
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "数据库导出Request", title = "数据库导出Request")
public class ShuJuKuDaoChuRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "云环境ID")
    private String env;
    @Schema(title = "导出文件路径（文件会导出到公共的云存储中，可使用")
    private String file_path;
    @Schema(title = "导出文件类型，1表示JSON；2表示CSV。文件格式参考")
    private Integer file_type;
    @Schema(title = "导出条件.")
    private String query;
}

