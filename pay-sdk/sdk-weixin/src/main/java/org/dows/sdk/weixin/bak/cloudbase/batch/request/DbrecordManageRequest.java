package org.dows.sdk.weixin.bak.cloudbase.batch.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/db-mgnt/dbrecordManage.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "DbrecordManageRequest", title = "DbrecordManageRequest")
public class DbrecordManageRequest {
    @Schema(title = "")
    private String access_token;
    @Schema(title = "填insert")
    private String action;
    @Schema(title = "云环境ID")
    private String env;
    @Schema(title = "数据库操作语句")
    private String query;
}

