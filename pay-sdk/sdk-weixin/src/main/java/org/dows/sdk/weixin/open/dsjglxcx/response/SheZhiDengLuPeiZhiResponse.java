package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/we-analysis/weDataSetLoginConfig.html
 *
 * @author lait.zhang@gmail.com
 * @description 设置登录配置
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "设置登录配置Response", title = "设置登录配置Response")
public class SheZhiDengLuPeiZhiResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

