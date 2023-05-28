package org.dows.sdk.weixin.ams.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "SetCoverAdposStatusRequest", title = "SetCoverAdposStatusRequest")
public class SetCoverAdposStatusRequest {
    @Schema(title = "开关状态：1开启，4关闭")
    private Integer status;
}

