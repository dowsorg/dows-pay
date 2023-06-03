package org.dows.sdk.weixin.open.xcxllzdyy.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/percentage/GetShareRatio.html
 *
 * @author lait.zhang@gmail.com
 * @description 查询分账比例
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "查询分账比例Request", title = "查询分账比例Request")
public class ChaXunFenZhangBiLiRequest {
    @Schema(title = "查询该APPID生效的分账比例。1、如果为服务商的APPID，则返回的是服务商此时生效的默认分账比例；2、如果为小程序的APPID，则返回的是小程序此时生效的分账比例，且分账比例为服务商分账比例，即服务商在该小程序的广告收益中的占比。")
    private String appid;
}

