package org.dows.sdk.weixin.open.xcxllzdyy.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-data/GetAdposGenenral.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取小程序广告汇总数据
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取小程序广告汇总数据Request", title = "获取小程序广告汇总数据Request")
public class HuoQuXiaoChengXuGuangGaoHuiZongShuJuRequest {
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

