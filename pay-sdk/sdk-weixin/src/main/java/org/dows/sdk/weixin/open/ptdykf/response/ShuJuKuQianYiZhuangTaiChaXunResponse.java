package org.dows.sdk.weixin.open.ptdykf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/file-management/getDatabaseMigrateStatus.html
 *
 * @author lait.zhang@gmail.com
 * @description 数据库迁移状态查询
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "数据库迁移状态查询Response", title = "数据库迁移状态查询Response")
public class ShuJuKuQianYiZhuangTaiChaXunResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "导出状态")
    private String status;
    @Schema(title = "导出成功记录数")
    private Integer record_success;
    @Schema(title = "导出失败记录数")
    private Integer record_fail;
    @Schema(title = "导出错误信息")
    private String error_msg;
    @Schema(title = "导出文件下载地址")
    private String file_url;
}

