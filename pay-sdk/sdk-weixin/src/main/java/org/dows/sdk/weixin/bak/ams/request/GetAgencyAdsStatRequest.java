package org.dows.sdk.weixin.bak.ams.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-data/GetAgencyAdsStat.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "GetAgencyAdsStatRequest", title = "GetAgencyAdsStatRequest")
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

