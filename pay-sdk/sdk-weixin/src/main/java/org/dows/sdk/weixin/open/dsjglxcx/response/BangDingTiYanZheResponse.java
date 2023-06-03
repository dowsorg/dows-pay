package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/member-management/bindTester.html
 *
 * @author lait.zhang@gmail.com
 * @description 绑定体验者
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "绑定体验者Response", title = "绑定体验者Response")
public class BangDingTiYanZheResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "人员对应的唯一字符串")
    private String userstr;
}

