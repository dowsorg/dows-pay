package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/setSupportVersion.html
 *
 * @author lait.zhang@gmail.com
 * @description 设置最低基础库版本
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "设置最低基础库版本Response", title = "设置最低基础库版本Response")
public class SheZhiZuiDiJiChuKuBanBenResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

