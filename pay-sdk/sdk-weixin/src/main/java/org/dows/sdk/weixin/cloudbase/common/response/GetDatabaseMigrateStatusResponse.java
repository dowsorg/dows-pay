package org.dows.sdk.weixin.cloudbase.common.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author
 * @description
 * @date 2023年5月28日 下午9:25:34
 * @date
 */
@Data
public class GetDatabaseMigrateStatusResponse {
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

