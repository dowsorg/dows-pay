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
public class GetCustomShareRatioRequest {
    @Schema(title = "查询用于该APPID签约时所使用的自定义分账比例。默认优先使用自定义分账比例，若不存在，则使用默认分账比例。")
    private String appid;
}

