package org.dows.sdk.weixin.cloudbase.common.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "DeleteDatabaseCollectionResponse", title = "DeleteDatabaseCollectionResponse")
public class DeleteDatabaseCollectionResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

