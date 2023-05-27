package org.dows.sdk.weixin.cloudbase.common.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author
 * @description
 * @date
 */
@Data
@NoArgsConstructor
public class AggregateDatabaseResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "记录数组")
    private List<String> data;

}
