package org.dows.sdk.weixin.cloudbase.common.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "DbcollectionManageRequest", title = "DbcollectionManageRequest")
public class DbcollectionManageRequest {
    @Schema(title = "")
    private String access_token;
    @Schema(title = "填'get'")
    private String action;
    @Schema(title = "环境ID")
    private String env;
    @Schema(title = "返回数据长度")
    private Integer limit;
    @Schema(title = "数据偏移量")
    private Integer offset;
}

