package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/shopping-orders/ShoppingInfoVerifyUploadResult.html
 *
 * @author lait.zhang@gmail.com
 * @description 验证购物订单上传结果
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "验证购物订单上传结果Request", title = "验证购物订单上传结果Request")
public class YanZhengGouWuDingDanShangChuanJieGuoRequest {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误原因")
    private String errmsg;
    @Schema(title = "验证结果")
    private String verify_result;
}

