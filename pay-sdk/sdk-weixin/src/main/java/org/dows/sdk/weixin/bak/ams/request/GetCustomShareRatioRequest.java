package org.dows.sdk.weixin.bak.ams.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/percentage/GetCustomShareRatio.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "GetCustomShareRatioRequest", title = "GetCustomShareRatioRequest")
public class GetCustomShareRatioRequest {
    @Schema(title = "查询用于该APPID签约时所使用的自定义分账比例。默认优先使用自定义分账比例，若不存在，则使用默认分账比例。")
    private String appid;
}

