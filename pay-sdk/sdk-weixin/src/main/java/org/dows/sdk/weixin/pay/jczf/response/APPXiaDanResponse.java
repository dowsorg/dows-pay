package org.dows.sdk.weixin.pay.jczf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_2_1.shtml
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年6月3日 上午10:38:50
 */
@Data
@Schema(name = "APP下单Response", title = "APP下单Response")
public class APPXiaDanResponse {
    @Schema(title = "预支付交易会话标识。用于后续接口调用中使用，该值有效期为2小时")
    private String prepay_id;
}

