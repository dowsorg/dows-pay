package org.dows.sdk.weixin.open.ptdykf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/getDatabaseRecord.html
 *
 * @author lait.zhang@gmail.com
 * @description 数据库查询记录
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "数据库查询记录Request", title = "数据库查询记录Request")
public class ShuJuKuChaXunJiLuRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "云环境ID")
    private String env;
    @Schema(title = "数据库操作语句")
    private String query;
}

