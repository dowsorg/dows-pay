package org.dows.sdk.weixin.miniprogram.management.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author
 * @description
 * @date 2023年5月28日 下午9:25:34
 * @date
 */
@Data
public class GetIllegalRecordsRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "查询时间段的开始时间，如果不填，则表示end_time之前90天内的记录")
    private Integer start_time;
    @Schema(title = "查询时间段的结束时间，如果不填，则表示start_time之后90天内的记录")
    private Integer end_time;
}

