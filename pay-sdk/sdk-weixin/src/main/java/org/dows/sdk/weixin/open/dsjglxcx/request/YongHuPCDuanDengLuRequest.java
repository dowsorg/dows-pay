package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/we-analysis/wedata_login.html
 *
 * @author lait.zhang@gmail.com
 * @description 用户PC端登录
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "用户PC端登录Request", title = "用户PC端登录Request")
public class YongHuPCDuanDengLuRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "服务商session，用户访问服务商系统的session")
    private String user_session;
    @Schema(title = "用户在服务商系统的唯一标识，可以是手机号、邮箱、员工ID等等")
    private String uid;
    @Schema(title = "用户的外网ip")
    private String client_ip;
    @Schema(title = "用户的user_agent")
    private String user_agent;
}

