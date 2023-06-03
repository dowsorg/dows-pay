package org.dows.sdk.weixin.pay.jczf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_4.shtml
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年6月3日 上午10:38:51
 */
@Data
@Schema(name = "合单小程序下单Response", title = "合单小程序下单Response")
public class HeDanXiaoChengXuXiaDanResponse {
    @Schema(title = "数字和字母。微信生成的预支付会话标识，用于后续接口调用使用，该值有效期为2小时。")
    private String prepay_id;
}

