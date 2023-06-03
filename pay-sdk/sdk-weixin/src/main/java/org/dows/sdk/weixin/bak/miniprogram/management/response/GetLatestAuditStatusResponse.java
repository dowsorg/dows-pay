package org.dows.sdk.weixin.bak.miniprogram.management.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/getLatestAuditStatus.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "GetLatestAuditStatusResponse", title = "GetLatestAuditStatusResponse")
public class GetLatestAuditStatusResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "最新的审核id")
    private Integer auditid;
    @Schema(title = "审核状态")
    private Integer status;
    @Schema(title = "当审核被拒绝时，返回的拒绝原因")
    private String reason;
    @Schema(title = "当审核被拒绝时，会返回审核失败的小程序截图示例。用 竖线I 分隔的 media_id 的列表，可通过获取永久素材接口拉取截图内容")
    private String screenshot;
    @Schema(title = "审核版本")
    private String user_version;
    @Schema(title = "版本描述")
    private String user_desc;
    @Schema(title = "时间戳，提交审核的时间")
    private Integer submit_audit_time;
}

