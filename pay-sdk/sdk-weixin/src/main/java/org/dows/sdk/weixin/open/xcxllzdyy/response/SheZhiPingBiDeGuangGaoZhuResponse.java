package org.dows.sdk.weixin.open.xcxllzdyy.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-black/SetBlackList.html
 *
 * @author lait.zhang@gmail.com
 * @description 设置屏蔽的广告主
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "设置屏蔽的广告主Response", title = "设置屏蔽的广告主Response")
public class SheZhiPingBiDeGuangGaoZhuResponse {
    @Schema(title = "错误码")
    private Integer ret;
    @Schema(title = "错误信息")
    private String err_msg;
}

