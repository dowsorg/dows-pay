package org.dows.sdk.weixin.open.xcxllzdyy.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/percentage/SetShareRatio.html
 *
 * @author lait.zhang@gmail.com
 * @description 设置默认分账比例
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "设置默认分账比例Response", title = "设置默认分账比例Response")
public class SheZhiMoRenFenZhangBiLiResponse {
    @Schema(title = "错误码")
    private Integer ret;
    @Schema(title = "错误信息")
    private String err_msg;
}

