package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/shopping-orders/confirmProductPermission.html
 *
 * @author lait.zhang@gmail.com
 * @description 提交购物订单接入审核
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "提交购物订单接入审核Response", title = "提交购物订单接入审核Response")
public class TiJiaoGouWuDingDanJieRuShenHeResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误原因")
    private String errmsg;
    @Schema(title = "最近一次审核的结果")
    private String last_result;
}

