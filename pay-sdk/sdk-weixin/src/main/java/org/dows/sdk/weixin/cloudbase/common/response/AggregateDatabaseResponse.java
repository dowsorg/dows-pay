package org.dows.sdk.weixin.cloudbase.common.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "AggregateDatabaseResponse", title = "AggregateDatabaseResponse")
public class AggregateDatabaseResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "记录数组")
    private List<String> data;
}

