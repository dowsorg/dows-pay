package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/getOrderPathInfo.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取订单页path信息
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取订单页path信息Request", title = "获取订单页path信息Request")
public class HuoQuDingDanYepathXinXiRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "0:线上版，1:审核版")
    private Integer info_type;
}

