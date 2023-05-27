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
public class GetAgencyTmplIdListRequest {
    @Schema(title = "返回第几页数据")
    private Integer page;
    @Schema(title = "当页返回数据条数")
    private Integer page_size;
    @Schema(title = "广告位类型名称")
    private String ad_slot;
    @Schema(title = "模板广告单元ID")
    private String tmpl_id;
    @Schema(title = "是否返回该模板广告单元ID绑定的商户广告单元信息")
    private Integer is_return_tmpl_bind_list;

}
