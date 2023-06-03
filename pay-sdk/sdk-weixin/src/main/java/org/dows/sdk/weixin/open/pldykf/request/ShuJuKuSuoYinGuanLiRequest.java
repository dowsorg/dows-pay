package org.dows.sdk.weixin.open.pldykf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/db-mgnt/dbindexManage.html
 *
 * @author lait.zhang@gmail.com
 * @description 数据库索引管理
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "数据库索引管理Request", title = "数据库索引管理Request")
public class ShuJuKuSuoYinGuanLiRequest {
    @Schema(title = "")
    private String access_token;
    @Schema(title = "create")
    private String action;
    @Schema(title = "环境ID")
    private String env;
    @Schema(title = "集合名称")
    private String collection_name;
    @Schema(title = "索引信息")
    private List<Object> indexes;
}

