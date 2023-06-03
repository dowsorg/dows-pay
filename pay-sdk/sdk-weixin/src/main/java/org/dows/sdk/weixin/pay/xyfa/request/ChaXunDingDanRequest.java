package org.dows.sdk.weixin.pay.xyfa.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_8_4.shtml
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年6月3日 上午10:38:52
 */
@Data
@Schema(name = "查询订单Request", title = "查询订单Request")
public class ChaXunDingDanRequest {
    @Schema(title = "")
    private String out_trade_no;
}

