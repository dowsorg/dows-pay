package org.dows.sdk.weixin.open.ptdykf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/addDatabaseItem.html
 *
 * @author lait.zhang@gmail.com
 * @description 数据库插入记录
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "数据库插入记录Response", title = "数据库插入记录Response")
public class ShuJuKuChaRuJiLuResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "插入成功的数据集合主键_id")
    private List<String> id_list;
}

