package org.dows.sdk.weixin.open.dsfptgl.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/openplatform-management/getOpenAccount.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取开放平台帐号
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取开放平台帐号Response", title = "获取开放平台帐号Response")
public class HuoQuKaiFangPingTaiZhangHaoResponse {
    @Schema(title = "公众号或小程序所绑定的开放平台帐号的 appid")
    private String open_appid;
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

