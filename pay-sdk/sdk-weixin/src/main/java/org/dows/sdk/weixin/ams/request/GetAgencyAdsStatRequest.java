package org.dows.sdk.weixin.ams.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author
 * @description
 * @date 2023年5月28日 下午9:25:34
 * @date
 */
@Data
public class GetAgencyAdsStatRequest {
    @Schema(title = "数据返回页数")
    private Integer page;
    @Schema(title = "每页返回数据条数")
    private Integer page_size;
    @Schema(title = "获取数据的开始时间yyyy-mm-dd")
    private String start_date;
    @Schema(title = "获取数据的结束时间yyyy-mm-dd")
    private String end_date;
    @Schema(title = "广告位类型名称")
    private String ad_slot;
}

