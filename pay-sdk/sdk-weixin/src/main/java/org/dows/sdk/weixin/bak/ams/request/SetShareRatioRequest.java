package org.dows.sdk.weixin.bak.ams.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/percentage/SetShareRatio.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "SetShareRatioRequest", title = "SetShareRatioRequest")
public class SetShareRatioRequest {
    @Schema(title = "服务商默认分账比例。如share_ratio为40，则代表服务商获得收益的40%，小程序商家获得收益的60%")
    private Integer share_ratio;
}

