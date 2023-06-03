package org.dows.sdk.weixin.open.dsfptgl.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/openplatform-management/createOpenAccount.html
 *
 * @author lait.zhang@gmail.com
 * @description 创建开放平台帐号
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "创建开放平台帐号Response", title = "创建开放平台帐号Response")
public class ChuangJianKaiFangPingTaiZhangHaoResponse {
    @Schema(title = "所创建的开放平台帐号的 appid")
    private String open_appid;
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

