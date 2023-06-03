package org.dows.sdk.weixin.bak.ams.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-data/GetAdposDetail.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "GetAdposDetailRequest", title = "GetAdposDetailRequest")
public class GetAdposDetailRequest {
    @Schema(title = "返回第几页数据")
    private Integer page;
    @Schema(title = "当页返回数据条数")
    private Integer page_size;
    @Schema(title = "获取数据的开始时间 yyyy-mm-dd")
    private String start_date;
    @Schema(title = "获取数据的结束时间 yyyy-mm-dd")
    private String end_date;
    @Schema(title = "广告位类型名称")
    private String ad_slot;
    @Schema(title = "广告单元ID")
    private String ad_unit_id;
}

