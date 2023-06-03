package org.dows.sdk.weixin.bak.cloudrun.batch.request;

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
@Schema(name = "ReleaseCloudbaseServiceVersionRequest", title = "ReleaseCloudbaseServiceVersionRequest")
public class ReleaseCloudbaseServiceVersionRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "环境id")
    private String env_id;
    @Schema(title = "服务名称")
    private String server_name;
    @Schema(title = "发布版本")
    private String release_version;
}

