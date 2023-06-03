package org.dows.sdk.weixin.bak.register.management.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/register-management/fast-regist-beta/registerBetaMiniprogram.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "RegisterBetaMiniprogramResponse", title = "RegisterBetaMiniprogramResponse")
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

