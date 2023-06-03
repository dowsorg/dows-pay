package org.dows.sdk.weixin.pay.jczf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_15.shtml
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年6月3日 上午10:38:51
 */
@Data
@Schema(name = "查询单笔退款Request", title = "查询单笔退款Request")
public class ChaXunDanBiTuiKuanRequest {
    @Schema(title = "")
    private String out_refund_no;
}

