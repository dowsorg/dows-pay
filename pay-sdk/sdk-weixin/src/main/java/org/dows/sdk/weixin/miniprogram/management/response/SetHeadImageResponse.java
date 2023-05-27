package org.dows.sdk.weixin.miniprogram.management.response;

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
public class SetHeadImageResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;

}
