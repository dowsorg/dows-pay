package org.dows.sdk.weixin.open.pldykf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/db-mgnt/dbImport.html
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
    @Schema(title = "导入任务ID，可使用")
    private Integer job_id;
}

