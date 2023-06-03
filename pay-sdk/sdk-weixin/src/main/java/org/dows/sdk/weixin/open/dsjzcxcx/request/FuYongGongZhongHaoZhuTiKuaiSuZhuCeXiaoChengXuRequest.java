package org.dows.sdk.weixin.open.dsjzcxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/register-management/fast-registration-officalaccount/registerMiniprogramByOffiaccount.html
 *
 * @author lait.zhang@gmail.com
 * @description 复用公众号主体快速注册小程序
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "复用公众号主体快速注册小程序Request", title = "复用公众号主体快速注册小程序Request")
public class FuYongGongZhongHaoZhuTiKuaiSuZhuCeXiaoChengXuRequest {
    @Schema(title = "第三方平台接口调用凭证")
    private String access_token;
    @Schema(title = "公众号扫码授权的凭证(公众平台扫码页面回跳到第三方平台时携带)，要看")
    private String ticket;
}

