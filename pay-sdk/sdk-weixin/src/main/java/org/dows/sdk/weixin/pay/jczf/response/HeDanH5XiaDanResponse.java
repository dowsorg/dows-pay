package org.dows.sdk.weixin.pay.jczf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_2.shtml
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年6月3日 上午10:38:51
 */
@Data
@Schema(name = "合单H5下单Response", title = "合单H5下单Response")
public class HeDanH5XiaDanResponse {
    @Schema(title = "支付跳转链接，h5_url的有效期为5分钟")
    private String h5_url;
}

