package org.dows.sdk.weixin.pay.jczf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_5.shtml
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年6月3日 上午10:38:51
 */
@Data
@Schema(name = "合单Native下单Response", title = "合单Native下单Response")
public class HeDanNativeXiaDanResponse {
    @Schema(title = "二维码链接")
    private String code_url;
}

