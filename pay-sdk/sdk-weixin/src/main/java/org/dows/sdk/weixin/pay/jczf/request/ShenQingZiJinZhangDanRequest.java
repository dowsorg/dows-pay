package org.dows.sdk.weixin.pay.jczf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_18.shtml
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年6月3日 上午10:38:51
 */
@Data
@Schema(name = "申请资金账单Request", title = "申请资金账单Request")
public class ShenQingZiJinZhangDanRequest {
    @Schema(title = "")
    private String bill_date;
    @Schema(title = "")
    private String account_type;
    @Schema(title = "")
    private String tar_type;
}

