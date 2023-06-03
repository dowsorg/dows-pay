package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/domain-management/modifyJumpDomain.html
 *
 * @author lait.zhang@gmail.com
 * @description 配置小程序业务域名
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "配置小程序业务域名Response", title = "配置小程序业务域名Response")
public class PeiZhiXiaoChengXuYeWuYuMingResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

