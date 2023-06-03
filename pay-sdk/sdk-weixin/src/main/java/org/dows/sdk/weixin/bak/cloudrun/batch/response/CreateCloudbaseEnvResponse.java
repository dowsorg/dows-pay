package org.dows.sdk.weixin.bak.cloudrun.batch.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/cloudenv-mgnt/createCloudbaseEnv.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "CreateCloudbaseEnvResponse", title = "CreateCloudbaseEnvResponse")
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

