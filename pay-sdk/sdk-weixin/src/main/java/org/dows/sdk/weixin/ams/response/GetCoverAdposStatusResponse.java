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
public class GetCoverAdposStatusResponse {
    @Schema(title = "错误码")
    private Number ret;

    @Schema(title = "错误信息")
    private Boolean err_msg;

    @Schema(title = "下次允许开启的封面广告位的时间")
    private Number next_open_time;

    @Schema(title = "封面广告位开关状态")
    private Number status;


}
