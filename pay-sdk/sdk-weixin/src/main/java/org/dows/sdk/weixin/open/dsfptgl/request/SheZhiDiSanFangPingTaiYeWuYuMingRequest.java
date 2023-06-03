package org.dows.sdk.weixin.open.dsfptgl.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/thirdparty-management/domain-mgnt/modifyThirdpartyJumpDomain.html
 *
 * @author lait.zhang@gmail.com
 * @description 设置第三方平台业务域名
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "设置第三方平台业务域名Request", title = "设置第三方平台业务域名Request")
public class SheZhiDiSanFangPingTaiYeWuYuMingRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "操作类型。可选值请看下文")
    private String action;
    @Schema(title = "最多可以添加200个小程序业务域名，以;隔开。注意：域名不需带有http:// 等协议内容，也不能在域名末尾附加详细的 URI 地址，严格按照类似 www.qq.com 的写法。")
    private String wxa_jump_h5_domain;
    @Schema(title = "是否同时修改“全网发布版本的值”。（false：只改“测试版”；true：同时改“测试版”和“全网发布版”）省略时，默认为false。")
    private Boolean is_modify_published_together;
}

