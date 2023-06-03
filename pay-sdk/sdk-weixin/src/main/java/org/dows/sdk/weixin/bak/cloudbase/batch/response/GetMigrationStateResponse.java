package org.dows.sdk.weixin.bak.cloudbase.batch.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/db-mgnt/getMigrationState.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "GetMigrationStateResponse", title = "GetMigrationStateResponse")
public class GetMigrationStateResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "导出状态")
    private String status;
    @Schema(title = "导出成功记录数")
    private Integer record_success;
    @Schema(title = "导出失败记录数")
    private Integer record_fail;
    @Schema(title = "导出错误信息")
    private String error_msg;
    @Schema(title = "导出文件下载地址")
    private String file_url;
}

