package org.dows.sdk.weixin.ams.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "GetCustomShareRatioRequest", title = "GetCustomShareRatioRequest")
public class GetCustomShareRatioRequest {
    @Schema(title = "查询用于该APPID签约时所使用的自定义分账比例。默认优先使用自定义分账比例，若不存在，则使用默认分账比例。")
    private String appid;
}

