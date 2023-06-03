package org.dows.sdk.weixin.bak.cloudrun.batch.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/cloudenv-mgnt/getShareCloudbaseEnv.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "GetShareCloudbaseEnvRequest", title = "GetShareCloudbaseEnvRequest")
public class GetShareCloudbaseEnvRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "要查询的appid")
    private List<String> appids;
    @Schema(title = "请求环境源，填 1，表示云托管环境")
    private Integer source_type;
}

