package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/subscribe-component/setShowItem.html
 *
 * @author lait.zhang@gmail.com
 * @description 设置扫码关注的公众号
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "设置扫码关注的公众号Response", title = "设置扫码关注的公众号Response")
public class SheZhiSaoMaGuanZhuDeGongZhongHaoResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

