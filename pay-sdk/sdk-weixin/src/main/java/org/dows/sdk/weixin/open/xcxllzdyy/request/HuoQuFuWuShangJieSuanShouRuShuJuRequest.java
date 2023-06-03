package org.dows.sdk.weixin.open.xcxllzdyy.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/settlement/GetAgencySettlement.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取服务商结算收入数据
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取服务商结算收入数据Request", title = "获取服务商结算收入数据Request")
public class HuoQuFuWuShangJieSuanShouRuShuJuRequest {
    @Schema(title = "数据返回页数")
    private Integer page;
    @Schema(title = "每页返回数据条数")
    private Integer page_size;
    @Schema(title = "获取数据的开始时间 yyyy-mm-dd")
    private String start_date;
    @Schema(title = "获取数据的结束时间 yyyy-mm-dd")
    private String end_date;
}

