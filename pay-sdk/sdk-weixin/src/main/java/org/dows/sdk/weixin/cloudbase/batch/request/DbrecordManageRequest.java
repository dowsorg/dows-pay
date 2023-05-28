package org.dows.sdk.weixin.cloudbase.batch.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月28日 下午9:55:33
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

