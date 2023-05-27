package org.dows.sdk.weixin.ams.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @description
 * @date
 */
@Data
@NoArgsConstructor
public class GetAgencySettlementRequest {
    @Schema(title = "数据返回页数")
    private Number page;

    @Schema(title = "每页返回数据条数")
    private Number page_size;

    @Schema(title = "获取数据的开始时间 yyyy-mm-dd")
    private String start_date;

    @Schema(title = "获取数据的结束时间 yyyy-mm-dd")
    private String end_date;


}
