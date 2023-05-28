package org.dows.sdk.weixin.register.management.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "FastRegisterPersonalMpResponse", title = "FastRegisterPersonalMpResponse")
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

