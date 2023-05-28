package org.dows.sdk.weixin.cloudrun.batch.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "ReleaseCloudbaseServiceVersionResponse", title = "ReleaseCloudbaseServiceVersionResponse")
public class ReleaseCloudbaseServiceVersionResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "是否成功，success是成功，failed是失败")
    private String result;
    @Schema(title = "发布单id")
    private Integer release_order_id;
}

