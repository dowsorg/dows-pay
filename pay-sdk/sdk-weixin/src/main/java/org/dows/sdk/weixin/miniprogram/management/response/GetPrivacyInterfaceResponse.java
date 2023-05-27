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
public class GetPrivacyInterfaceResponse {
    @Schema(title = "待申请开通")
    private;

    @Schema(title = "无权限")
    private;

    @Schema(title = "申请中")
    private;

    @Schema(title = "申请失败")
    private;

    @Schema(title = "已开通")
    private;


}
