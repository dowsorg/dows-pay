package org.dows.sdk.weixin.ams.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author
 * @description
 * @date 2023年5月28日 下午9:25:34
 * @date
 */
@Data
public class SetCustomShareRatioRequest {
    @Schema(title = "服务商自定义分账比例。签约时，默认优先使用自定义分账比例，若不存在，则使用默认分账比例。如share_ratio为40，则代表服务商获得收益的40%，小程序商家获得收益的60%")
    private Integer share_ratio;
    @Schema(title = "针对该小程序APPID设置自定义分账比例。")
    private String appid;
}

