package org.dows.sdk.weixin.open.dsfptgl.request;

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
@Schema(name = "获取开放平台帐号Request", title = "获取开放平台帐号Request")
public class HuoQuKaiFangPingTaiZhangHaoRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "非必填，如果不填则取生成authorizer_access_token的授权公众号或小程序的 appid。如果填，则需要填与生成authorizer_access_token的授权公众号或小程序的 appid一致的appid，否则会出现40013报错。")
    private String appid;
}

