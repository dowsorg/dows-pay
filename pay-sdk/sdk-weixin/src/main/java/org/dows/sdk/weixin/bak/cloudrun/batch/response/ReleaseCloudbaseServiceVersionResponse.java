package org.dows.sdk.weixin.bak.cloudrun.batch.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/service-mgnt/releaseCloudbaseServiceVersion.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
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

