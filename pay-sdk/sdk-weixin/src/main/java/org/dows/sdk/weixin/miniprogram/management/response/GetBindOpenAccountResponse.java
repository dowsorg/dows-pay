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
public class GetBindOpenAccountResponse {
    @Schema(title = "是否绑定open帐号，true表示绑定；false表示未绑定任何open帐号")
    private Boolean have_open;

    @Schema(title = "返回码")
    private Number errcode;

    @Schema(title = "错误信息")
    private String errmsg;


}
