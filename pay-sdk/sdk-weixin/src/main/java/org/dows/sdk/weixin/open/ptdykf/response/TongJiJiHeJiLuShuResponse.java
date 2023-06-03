package org.dows.sdk.weixin.open.ptdykf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/getDatabaseCount.html
 *
 * @author lait.zhang@gmail.com
 * @description 统计集合记录数
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "统计集合记录数Response", title = "统计集合记录数Response")
public class TongJiJiHeJiLuShuResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "记录数量")
    private Integer count;
}

