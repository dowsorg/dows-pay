package org.dows.sdk.weixin.bak.cloudbase.batch.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/env-mgnt/createTcbEnv.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "CreateTcbEnvResponse", title = "CreateTcbEnvResponse")
public class CreateTcbEnvResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "后付费订单号")
    private String tranid;
    @Schema(title = "环境ID")
    private String env;
}

