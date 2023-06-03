package org.dows.sdk.weixin.open.xcxllzdyy.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-mgnt/GetAdunitCode.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取广告单元代码
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取广告单元代码Response", title = "获取广告单元代码Response")
public class HuoQuGuangGaoDanYuanDaiMaResponse {
    @Schema(title = "错误码")
    private Integer ret;
    @Schema(title = "错误信息")
    private String err_msg;
    @Schema(title = "广告单元ID对应代码")
    private String code;
}

