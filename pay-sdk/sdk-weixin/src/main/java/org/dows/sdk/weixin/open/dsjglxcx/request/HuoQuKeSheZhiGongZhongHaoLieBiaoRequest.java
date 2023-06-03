package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/subscribe-component/getLinkForShow.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取可设置公众号列表
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取可设置公众号列表Request", title = "获取可设置公众号列表Request")
public class HuoQuKeSheZhiGongZhongHaoLieBiaoRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "页码，从 0 开始")
    private Integer page;
    @Schema(title = "每页记录数，最大为 20")
    private Integer num;
}

