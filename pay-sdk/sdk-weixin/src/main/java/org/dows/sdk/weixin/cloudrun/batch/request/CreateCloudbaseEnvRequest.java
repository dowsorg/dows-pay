package org.dows.sdk.weixin.cloudrun.batch.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author
 * @description
 * @date
 */
@Data
@NoArgsConstructor
public class CreateCloudbaseEnvRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "环境别名，要以a-z开头，不能包含 a-z,0-9,- 以外的字符")
    private String alias;
    @Schema(title = "私有网络Id")
    private String vpc_id;
    @Schema(title = "子网列表")
    private List<String> sub_net_ids;

}
