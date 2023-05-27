package org.dows.sdk.weixin.cloudbase.common.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @description
 * @date
 */
@Data
@NoArgsConstructor
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
