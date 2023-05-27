package org.dows.sdk.weixin.thirdparty.management.response;

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
public class GetTemplateListResponse {
    @Schema(title = "未提审核")
    private;

    @Schema(title = "审核中")
    private;

    @Schema(title = "审核驳回")
    private;

    @Schema(title = "审核通过")
    private;

    @Schema(title = "提审中")
    private;

    @Schema(title = "提审失败")
    private;


}
