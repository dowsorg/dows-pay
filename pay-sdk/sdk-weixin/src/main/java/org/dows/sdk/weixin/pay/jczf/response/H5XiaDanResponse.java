package org.dows.sdk.weixin.pay.jczf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_1.shtml
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年6月3日 上午10:38:51
 */
@Data
@Schema(name = "H5下单Response", title = "H5下单Response")
public class H5XiaDanResponse {
    @Schema(title = "商户系统内部的商家批次单号")
    private String out_batch_no;
    @Schema(title = "微信批次单号，微信商家转账系统返回的唯一标识")
    private String batch_id;
    @Schema(title = "批次受理成功时返回，遵循")
    private String create_time;
}

