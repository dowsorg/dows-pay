package org.dows.sdk.weixin.ams.request;

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
public class SetCoverAdposStatusRequest {
    @Schema(title = "开关状态：1开启，4关闭")
    private Integer status;

}
