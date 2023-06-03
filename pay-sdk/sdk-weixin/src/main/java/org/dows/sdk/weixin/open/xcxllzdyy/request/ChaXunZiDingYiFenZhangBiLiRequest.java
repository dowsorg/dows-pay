package org.dows.sdk.weixin.open.xcxllzdyy.request;

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
@Schema(name = "查询自定义分账比例Request", title = "查询自定义分账比例Request")
public class ChaXunZiDingYiFenZhangBiLiRequest {
    @Schema(title = "查询用于该APPID签约时所使用的自定义分账比例。默认优先使用自定义分账比例，若不存在，则使用默认分账比例。")
    private String appid;
}

