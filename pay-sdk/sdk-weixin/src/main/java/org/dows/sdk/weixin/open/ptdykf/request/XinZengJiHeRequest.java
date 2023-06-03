package org.dows.sdk.weixin.open.ptdykf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/addDatabaseCollection.html
 *
 * @author lait.zhang@gmail.com
 * @description 新增集合
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "新增集合Request", title = "新增集合Request")
public class XinZengJiHeRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "云环境ID")
    private String env;
    @Schema(title = "集合名称")
    private String collection_name;
}

