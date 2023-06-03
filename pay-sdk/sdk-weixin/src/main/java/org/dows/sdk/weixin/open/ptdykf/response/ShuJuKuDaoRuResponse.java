package org.dows.sdk.weixin.open.ptdykf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/importDatabaseItem.html
 *
 * @author lait.zhang@gmail.com
 * @description 数据库导入
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "数据库导入Response", title = "数据库导入Response")
public class ShuJuKuDaoRuResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "导入任务ID，可使用getDatabaseMigrateStatus接口查询导入进度及结果")
    private Integer job_id;
}

