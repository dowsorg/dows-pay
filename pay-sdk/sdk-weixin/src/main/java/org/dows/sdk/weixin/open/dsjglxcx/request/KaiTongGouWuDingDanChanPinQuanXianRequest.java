package org.dows.sdk.weixin.open.dsjglxcx.request;

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
@Schema(name = "开通购物订单产品权限Request", title = "开通购物订单产品权限Request")
public class KaiTongGouWuDingDanChanPinQuanXianRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
}

