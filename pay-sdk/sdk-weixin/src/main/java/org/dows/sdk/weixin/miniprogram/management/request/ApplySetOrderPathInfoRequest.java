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
public class ApplySetOrderPathInfoRequest {
    @Schema(title = "返回码")
    private Number errcode;

    @Schema(title = "返回码信息")
    private String errmsg;


}
