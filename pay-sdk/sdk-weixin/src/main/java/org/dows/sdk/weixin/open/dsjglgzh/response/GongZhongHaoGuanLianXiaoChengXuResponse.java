package org.dows.sdk.weixin.open.dsjglgzh.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/officalaccount-management/link-miniprogram/linkMiniprogram.html
 *
 * @author lait.zhang@gmail.com
 * @description 公众号关联小程序
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "公众号关联小程序Response", title = "公众号关联小程序Response")
public class GongZhongHaoGuanLianXiaoChengXuResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

