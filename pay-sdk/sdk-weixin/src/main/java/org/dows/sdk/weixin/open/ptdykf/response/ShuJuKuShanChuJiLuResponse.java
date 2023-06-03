package org.dows.sdk.weixin.open.ptdykf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/deleteDatabaseItem.html
 *
 * @author lait.zhang@gmail.com
 * @description 数据库删除记录
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "数据库删除记录Response", title = "数据库删除记录Response")
public class ShuJuKuShanChuJiLuResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "删除记录数量")
    private Integer deleted;
}

