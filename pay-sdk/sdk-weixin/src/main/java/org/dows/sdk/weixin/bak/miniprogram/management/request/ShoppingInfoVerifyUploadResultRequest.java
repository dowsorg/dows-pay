package org.dows.sdk.weixin.bak.miniprogram.management.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/shopping-orders/ShoppingInfoVerifyUploadResult.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "ShoppingInfoVerifyUploadResultRequest", title = "ShoppingInfoVerifyUploadResultRequest")
public class ShoppingInfoVerifyUploadResultRequest {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误原因")
    private String errmsg;
    @Schema(title = "验证结果")
    private String verify_result;
}

