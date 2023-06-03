package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/setCodeAuditQuota.html
 *
 * @author lait.zhang@gmail.com
 * @description 查询服务商审核额度
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "查询服务商审核额度Response", title = "查询服务商审核额度Response")
public class ChaXunFuWuShangShenHeEDuResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "quota剩余值")
    private Integer rest;
    @Schema(title = "当月分配quota")
    private Integer limit;
    @Schema(title = "剩余加急次数")
    private Integer speedup_rest;
    @Schema(title = "当月分配加急次数")
    private Integer speedup_limit;
}

