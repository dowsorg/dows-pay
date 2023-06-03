package org.dows.sdk.weixin.bak.register.management.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/register-management/fast-registration-ind/fastRegisterPersonalMp.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
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

