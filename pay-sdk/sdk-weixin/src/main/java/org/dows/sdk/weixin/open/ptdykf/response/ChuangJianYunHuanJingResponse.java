package org.dows.sdk.weixin.open.ptdykf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/env-management/createEnv.html
 *
 * @author lait.zhang@gmail.com
 * @description 创建云环境
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "创建云环境Response", title = "创建云环境Response")
public class ChuangJianYunHuanJingResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "环境id")
    private String envid;
}

