package org.dows.sdk.weixin.ams.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @description
 * @date
 */
@Data
@NoArgsConstructor
public class GetShareRatioResponse {
    @Schema(title = "错误码")
    private Number ret;

    @Schema(title = "错误信息")
    private String err_msg;

    @Schema(title = "服务商的分成比例")
    private Number share_ratio;


}
