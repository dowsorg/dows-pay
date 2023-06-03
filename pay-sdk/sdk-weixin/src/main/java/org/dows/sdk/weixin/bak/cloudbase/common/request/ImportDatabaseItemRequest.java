package org.dows.sdk.weixin.bak.cloudbase.common.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/importDatabaseItem.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "ImportDatabaseItemRequest", title = "ImportDatabaseItemRequest")
public class ImportDatabaseItemRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "云环境ID")
    private String env;
    @Schema(title = "导入 collection 名")
    private String collection_name;
    @Schema(title = "导入文件路径(导入文件需先上传到同环境的存储中，可使用开发者工具或 getUploadTcbFileLink接口上传）")
    private String file_path;
    @Schema(title = "导入文件类型。1表示JSON。2表示CSV")
    private Integer file_type;
    @Schema(title = "是否在遇到错误时停止导入")
    private Boolean stop_on_error;
    @Schema(title = "冲突处理模式。1表示INSERT。2表示UPSERT。")
    private Integer conflict_mode;
}

