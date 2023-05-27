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
public class RegisterBetaMiniprogramResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "该请求的唯一标识符，用于关联微信用户和后面产生的appid")
    private String unique_id;
    @Schema(title = "用户授权确认url，需将该url发送给用户，小程序管理员在微信打开并进入授权页面完成授权方可创建小程序")
    private String authorize_url;

}
