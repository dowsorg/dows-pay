package org.dows.sdk.weixin.ams.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "GetAdposGenenralRequest", title = "GetAdposGenenralRequest")
public class GetAdposGenenralRequest {
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
}

