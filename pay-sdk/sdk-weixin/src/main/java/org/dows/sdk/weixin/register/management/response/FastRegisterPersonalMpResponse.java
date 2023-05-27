package org.dows.sdk.weixin.register.management.response;

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
public class FastRegisterPersonalMpResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "任务id，后面query查询需要用到")
    private String taskid;
    @Schema(title = "给用户扫码认证的验证url")
    private String authorize_url;
    @Schema(title = "任务的状态")
    private Integer status;

}
