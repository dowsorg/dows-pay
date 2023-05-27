package org.dows.sdk.weixin.cloudrun.batch.response;

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
public class ReleaseCloudbaseServiceVersionResponse {
    @Schema(title = "错误码")
    private Number errcode;

    @Schema(title = "错误信息")
    private String errmsg;

    @Schema(title = "是否成功，success是成功，failed是失败")
    private String result;

    @Schema(title = "发布单id")
    private Number release_order_id;


}
