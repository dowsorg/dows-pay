package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/grayRelease.html
 *
 * @author lait.zhang@gmail.com
 * @description 分阶段发布
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "分阶段发布Response", title = "分阶段发布Response")
public class FenJieDuanFaBuResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

