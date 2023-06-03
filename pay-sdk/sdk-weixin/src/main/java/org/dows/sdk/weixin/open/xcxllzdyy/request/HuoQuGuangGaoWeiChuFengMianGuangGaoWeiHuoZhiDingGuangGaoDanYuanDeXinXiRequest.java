package org.dows.sdk.weixin.open.xcxllzdyy.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-mgnt/GetAdunitList.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取广告位（除封面广告位）或指定广告单元的信息
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取广告位（除封面广告位）或指定广告单元的信息Request", title = "获取广告位（除封面广告位）或指定广告单元的信息Request")
public class HuoQuGuangGaoWeiChuFengMianGuangGaoWeiHuoZhiDingGuangGaoDanYuanDeXinXiRequest {
    @Schema(title = "返回第几页数据")
    private Integer page;
    @Schema(title = "当页返回数据条数")
    private Integer page_size;
    @Schema(title = "广告位类型名称")
    private String ad_slot;
    @Schema(title = "广告单元ID")
    private String ad_unit_id;
}

