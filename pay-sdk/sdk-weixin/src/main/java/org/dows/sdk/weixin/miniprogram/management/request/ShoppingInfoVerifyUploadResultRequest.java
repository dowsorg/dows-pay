package org.dows.sdk.weixin.miniprogram.management.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @description
 * @date
 */
@Data
@NoArgsConstructor
public class ShoppingInfoVerifyUploadResultRequest {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误原因")
    private String errmsg;
    @Schema(title = "验证结果")
    private String verify_result;

}
