package org.dows.sdk.weixin.cloudbase.common.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "ImportDatabaseItemResponse", title = "ImportDatabaseItemResponse")
public class ImportDatabaseItemResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "导入任务ID，可使用getDatabaseMigrateStatus接口查询导入进度及结果")
    private Integer job_id;
}

