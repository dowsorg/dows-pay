package org.dows.sdk.weixin.open.ptdykf.response;

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
@Schema(name = "新增集合Response", title = "新增集合Response")
public class XinZengJiHeResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

