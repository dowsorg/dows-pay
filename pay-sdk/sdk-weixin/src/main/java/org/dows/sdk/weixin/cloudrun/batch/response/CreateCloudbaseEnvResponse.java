package org.dows.sdk.weixin.cloudrun.batch.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author
 * @description
 * @date 2023年5月28日 下午9:25:34
 * @date
 */
@Data
public class CreateCloudbaseEnvResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "环境id")
    private String env_id;
    @Schema(title = "后付费订单号")
    private String tran_id;
}

