package org.dows.sdk.weixin.ams.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "GetCoverAdposStatusResponse", title = "GetCoverAdposStatusResponse")
public class GetCoverAdposStatusResponse {
    @Schema(title = "错误码")
    private Integer ret;
    @Schema(title = "错误信息")
    private Boolean err_msg;
    @Schema(title = "下次允许开启的封面广告位的时间")
    private Integer next_open_time;
    @Schema(title = "封面广告位开关状态")
    private Integer status;
}

