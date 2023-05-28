package org.dows.sdk.weixin.ams.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "AgencyCreateAdunitResponse", title = "AgencyCreateAdunitResponse")
public class AgencyCreateAdunitResponse {
    @Schema(title = "错误码")
    private Integer ret;
    @Schema(title = "错误信息")
    private String err_msg;
    @Schema(title = "广告单元ID")
    private String ad_unit_id;
}

