package org.dows.sdk.weixin.open.pldykf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/db-mgnt/dbrecordManage.html
 *
 * @author lait.zhang@gmail.com
 * @description 数据库记录管理
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "数据库记录管理Request", title = "数据库记录管理Request")
public class ShuJuKuJiLuGuanLiRequest {
    @Schema(title = "")
    private String access_token;
    @Schema(title = "填insert")
    private String action;
    @Schema(title = "云环境ID")
    private String env;
    @Schema(title = "数据库操作语句")
    private String query;
}

