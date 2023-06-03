package org.dows.sdk.weixin.open.xcxllzdyy.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-mgnt/SetCoverAdposStatus.html
 *
 * @author lait.zhang@gmail.com
 * @description 设置封面广告位开关状态
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "设置封面广告位开关状态Request", title = "设置封面广告位开关状态Request")
public class SheZhiFengMianGuangGaoWeiKaiGuanZhuangTaiRequest {
    @Schema(title = "开关状态：1开启，4关闭")
    private Integer status;
}

