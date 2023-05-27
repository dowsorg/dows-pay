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
public class GetAccountBasicInfoResponse {
    @Schema(title = "个人")
    private;

    @Schema(title = "企业")
    private;

    @Schema(title = "媒体")
    private;

    @Schema(title = "政府")
    private;

    @Schema(title = "其他组织")
    private;


}
