package org.dows.sdk.weixin.open.xcxllzdyy.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/percentage/GetCustomShareRatio.html
 *
 * @author lait.zhang@gmail.com
 * @description 查询自定义分账比例
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "查询自定义分账比例Response", title = "查询自定义分账比例Response")
public class ChaXunZiDingYiFenZhangBiLiResponse {
    @Schema(title = "错误码")
    private Integer ret;
    @Schema(title = "错误信息")
    private String err_msg;
    @Schema(title = "服务商的分账比例")
    private Integer share_ratio;
}

