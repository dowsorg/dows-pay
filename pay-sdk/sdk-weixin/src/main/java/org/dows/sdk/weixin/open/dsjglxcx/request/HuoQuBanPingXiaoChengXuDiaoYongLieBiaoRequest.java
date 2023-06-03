package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/embedded-management/getEmbeddedList.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取半屏小程序调用列表
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取半屏小程序调用列表Request", title = "获取半屏小程序调用列表Request")
public class HuoQuBanPingXiaoChengXuDiaoYongLieBiaoRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "query参数，分页起始值 ，默认值为0")
    private Integer start;
    @Schema(title = "query参数，一次拉取最大值，最大 1000，默认值为10")
    private Integer num;
}

