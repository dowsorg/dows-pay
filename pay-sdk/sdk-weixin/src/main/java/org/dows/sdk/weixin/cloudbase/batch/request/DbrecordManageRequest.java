package org.dows.sdk.weixin.cloudbase.batch.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author
 * @description
 * @date 2023年5月28日 下午9:25:34
 * @date
 */
@Data
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

