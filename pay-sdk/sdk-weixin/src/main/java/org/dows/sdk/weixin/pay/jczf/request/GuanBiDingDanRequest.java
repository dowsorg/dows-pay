package org.dows.sdk.weixin.pay.jczf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_5_3.shtml
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年6月3日 上午10:38:51
 */
@Data
@Schema(name = "关闭订单Request", title = "关闭订单Request")
public class GuanBiDingDanRequest {
    @Schema(title = "")
    private String sp_mchid;
    @Schema(title = "")
    private String sub_mchid;
    @Schema(title = "")
    private String out_trade_no;
}

