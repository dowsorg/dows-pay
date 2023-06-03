package org.dows.sdk.weixin.open.xcxllzdyy.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-mgnt/AgencyCreateAdunit.html
 *
 * @author lait.zhang@gmail.com
 * @description 创建广告单元
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "创建广告单元Response", title = "创建广告单元Response")
public class ChuangJianGuangGaoDanYuanResponse {
    @Schema(title = "错误码")
    private Integer ret;
    @Schema(title = "错误信息")
    private String err_msg;
    @Schema(title = "广告单元ID")
    private String ad_unit_id;
}

