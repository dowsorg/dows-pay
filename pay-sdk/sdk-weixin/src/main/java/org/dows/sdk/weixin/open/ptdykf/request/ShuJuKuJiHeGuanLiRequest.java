package org.dows.sdk.weixin.open.ptdykf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/dbcollectionManage.html
 *
 * @author lait.zhang@gmail.com
 * @description 数据库集合管理
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "数据库集合管理Request", title = "数据库集合管理Request")
public class ShuJuKuJiHeGuanLiRequest {
    @Schema(title = "")
    private String access_token;
    @Schema(title = "填'get'")
    private String action;
    @Schema(title = "环境ID")
    private String env;
    @Schema(title = "返回数据长度")
    private Integer limit;
    @Schema(title = "数据偏移量")
    private Integer offset;
}

