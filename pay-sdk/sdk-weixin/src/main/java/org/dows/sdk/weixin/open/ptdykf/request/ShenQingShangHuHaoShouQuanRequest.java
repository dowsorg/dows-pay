package org.dows.sdk.weixin.open.ptdykf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/wechatpay/getWechatPayAuth.html
 *
 * @author lait.zhang@gmail.com
 * @description 申请商户号授权
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "申请商户号授权Request", title = "申请商户号授权Request")
public class ShenQingShangHuHaoShouQuanRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "bind/openjsapi/openrefund")
    private String action;
    @Schema(title = "商户号")
    private String merchant_code;
}

