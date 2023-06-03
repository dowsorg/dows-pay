package org.dows.sdk.weixin.open.wxytg.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/service-mgnt/deleteCloudbaseServiceVersion.html
 *
 * @author lait.zhang@gmail.com
 * @description 删除服务版本
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "删除服务版本Request", title = "删除服务版本Request")
public class ShanChuFuWuBanBenRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "环境ID")
    private String env_id;
    @Schema(title = "服务名称")
    private String server_name;
    @Schema(title = "版本名称")
    private String version_name;
    @Schema(title = "是否删除服务，只有最后一个版本的时候，才生效。")
    private Boolean is_delete_server;
    @Schema(title = "是否删除镜像。只有删除服务的时候，才会起作用")
    private Boolean is_delete_image;
}

