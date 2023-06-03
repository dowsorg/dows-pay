package org.dows.sdk.weixin.open.pldykf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/db-mgnt/getMigrationState.html
 *
 * @author lait.zhang@gmail.com
 * @description 数据库状态查询
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "数据库状态查询Request", title = "数据库状态查询Request")
public class ShuJuKuZhuangTaiChaXunRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "环境ID")
    private String env;
    @Schema(title = "迁移任务ID")
    private Integer job_id;
}

