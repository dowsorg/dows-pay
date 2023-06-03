package org.dows.sdk.weixin.open.ptdykf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/updateDatabaseIndex.html
 *
 * @author lait.zhang@gmail.com
 * @description 更新数据库索引
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "更新数据库索引Response", title = "更新数据库索引Response")
public class GengXinShuJuKuSuoYinResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

