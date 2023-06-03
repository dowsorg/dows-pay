package org.dows.sdk.weixin.pay.jczf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_4_1.shtml
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年6月3日 上午10:38:51
 */
@Data
@Schema(name = "Native下单Response", title = "Native下单Response")
public class NativeXiaDanResponse {
    @Schema(title = "此URL用于生成支付二维码，然后提供给用户扫码支付。")
    private String code_url;
}

