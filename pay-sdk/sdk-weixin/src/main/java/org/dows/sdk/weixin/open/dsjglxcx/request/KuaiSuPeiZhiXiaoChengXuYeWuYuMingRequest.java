package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/domain-management/modifyJumpDomainDirectly.html
 *
 * @author lait.zhang@gmail.com
 * @description 快速配置小程序业务域名
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "快速配置小程序业务域名Request", title = "快速配置小程序业务域名Request")
public class KuaiSuPeiZhiXiaoChengXuYeWuYuMingRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "操作类型")
    private String action;
    @Schema(title = "小程序业务域名，当 action 参数是 get 时不需要此字段")
    private List<String> webviewdomain;
}

