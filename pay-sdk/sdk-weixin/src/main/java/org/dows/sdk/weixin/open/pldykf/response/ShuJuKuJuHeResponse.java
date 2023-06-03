package org.dows.sdk.weixin.open.pldykf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/db-mgnt/dbAggregate.html
 *
 * @author lait.zhang@gmail.com
 * @description 数据库聚合
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "数据库聚合Response", title = "数据库聚合Response")
public class ShuJuKuJuHeResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "记录数组")
    private List<String> data;
}

