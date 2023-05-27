package org.dows.sdk.weixin.miniprogram.management.response;

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
public class GetOrderPathInfoResponse {
    @Schema(title = "审核中")
    private;

    @Schema(title = "审核失败")
    private;

    @Schema(title = "审核通过")
    private;


}
