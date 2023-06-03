package org.dows.sdk.weixin.bak.miniprogram.management.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/member-management/unbindTester.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "UnbindTesterRequest", title = "UnbindTesterRequest")
public class UnbindTesterRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "微信号。 userstr 和 wechatid 填写其中一个即可")
    private String wechatid;
    @Schema(title = "人员对应的唯一字符串， 可通过getTester接口获取人员对应的字符串")
    private String userstr;
}

