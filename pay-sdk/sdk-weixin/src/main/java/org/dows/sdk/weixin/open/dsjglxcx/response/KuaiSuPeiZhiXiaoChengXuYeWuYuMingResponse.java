package org.dows.sdk.weixin.open.dsjglxcx.response;

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
@Schema(name = "快速配置小程序业务域名Response", title = "快速配置小程序业务域名Response")
public class KuaiSuPeiZhiXiaoChengXuYeWuYuMingResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "业务域名")
    private List<String> webviewdomain;
}

