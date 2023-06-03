package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/logistics-service/applyReturnPlugin.html
 *
 * @author lait.zhang@gmail.com
 * @description 申请开通物流退货组件
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "申请开通物流退货组件Response", title = "申请开通物流退货组件Response")
public class ShenQingKaiTongWuLiuTuiHuoZuJianResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

