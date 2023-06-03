package org.dows.sdk.weixin.pay.jczf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_17.shtml
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年6月3日 上午10:38:51
 */
@Data
@Schema(name = "申请交易账单Request", title = "申请交易账单Request")
public class ShenQingJiaoYiZhangDanRequest {
    @Schema(title = "")
    private String bill_date;
    @Schema(title = "")
    private String bill_type;
    @Schema(title = "")
    private String tar_type;
}

