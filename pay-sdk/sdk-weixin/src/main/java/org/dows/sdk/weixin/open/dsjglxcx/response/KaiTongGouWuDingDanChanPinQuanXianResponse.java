package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/shopping-orders/openShoppingOrderProductPermission.html
 *
 * @author lait.zhang@gmail.com
 * @description 开通购物订单产品权限
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "开通购物订单产品权限Response", title = "开通购物订单产品权限Response")
public class KaiTongGouWuDingDanChanPinQuanXianResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误原因")
    private String errmsg;
}

