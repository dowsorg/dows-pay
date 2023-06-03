package org.dows.sdk.weixin.open.pldykf.response;

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
@Schema(name = "数据库导出Response", title = "数据库导出Response")
public class ShuJuKuDaoChuResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "导出任务ID，使用")
    private Integer job_id;
}

