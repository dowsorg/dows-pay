package org.dows.sdk.weixin.open.dsfptgl.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/openplatform-management/unbindOpenAccount.html
 *
 * @author lait.zhang@gmail.com
 * @description 解除绑定开放平台帐号
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "解除绑定开放平台帐号Response", title = "解除绑定开放平台帐号Response")
public class JieChuBangDingKaiFangPingTaiZhangHaoResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

