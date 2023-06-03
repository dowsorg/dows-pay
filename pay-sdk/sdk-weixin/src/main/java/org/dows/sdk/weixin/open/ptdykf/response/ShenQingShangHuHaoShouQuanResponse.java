package org.dows.sdk.weixin.open.ptdykf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/wechatpay/getWechatPayAuth.html
 *
 * @author lait.zhang@gmail.com
 * @description 申请商户号授权
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "申请商户号授权Response", title = "申请商户号授权Response")
public class ShenQingShangHuHaoShouQuanResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

