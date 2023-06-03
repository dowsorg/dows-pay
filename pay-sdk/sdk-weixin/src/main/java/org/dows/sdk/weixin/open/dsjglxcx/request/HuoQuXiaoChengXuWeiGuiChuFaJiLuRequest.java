package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/record-management/getIllegalRecords.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取小程序违规处罚记录
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取小程序违规处罚记录Request", title = "获取小程序违规处罚记录Request")
public class HuoQuXiaoChengXuWeiGuiChuFaJiLuRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "查询时间段的开始时间，如果不填，则表示end_time之前90天内的记录")
    private Integer start_time;
    @Schema(title = "查询时间段的结束时间，如果不填，则表示start_time之后90天内的记录")
    private Integer end_time;
}

