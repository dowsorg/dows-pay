package org.dows.sdk.weixin.open.ptdykf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/env-management/shareEnv.html
 *
 * @author lait.zhang@gmail.com
 * @description 环境共享
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "环境共享Response", title = "环境共享Response")
public class HuanJingGongXiangResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

