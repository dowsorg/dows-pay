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
public class CreateCloudbaseEnvResponse {
    @Schema(title = "错误码")
    private Number errcode;

    @Schema(title = "错误信息")
    private String errmsg;

    @Schema(title = "环境id")
    private String env_id;

    @Schema(title = "后付费订单号")
    private String tran_id;


}
