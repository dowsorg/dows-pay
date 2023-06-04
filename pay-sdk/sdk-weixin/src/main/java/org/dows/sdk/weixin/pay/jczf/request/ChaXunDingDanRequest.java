package org.dows.sdk.weixin.pay.jczf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_5_2.shtml
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年6月3日 上午10:38:51
 */
@Data
@Schema(name = "查询订单Request", title = "查询订单Request")
public class ChaXunDingDanRequest {
    @Schema(title = "")
    private String sp_mchid;
    @Schema(title = "")
    private String sub_mchid;
    @Schema(title = "")
    private String transaction_id;
    //    @Schema(title = "")
//    private String sp_mchid;
//    @Schema(title = "")
//    private String sub_mchid;
    @Schema(title = "")
    private String out_trade_no;
}

