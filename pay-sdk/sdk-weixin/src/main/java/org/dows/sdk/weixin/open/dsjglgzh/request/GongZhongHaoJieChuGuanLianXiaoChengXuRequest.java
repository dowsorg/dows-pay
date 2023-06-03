package org.dows.sdk.weixin.open.dsjglgzh.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/officalaccount-management/link-miniprogram/unlinkMiniprogram.html
 *
 * @author lait.zhang@gmail.com
 * @description 公众号解除关联小程序
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "公众号解除关联小程序Request", title = "公众号解除关联小程序Request")
public class GongZhongHaoJieChuGuanLianXiaoChengXuRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "小程序 appid")
    private String appid;
}

