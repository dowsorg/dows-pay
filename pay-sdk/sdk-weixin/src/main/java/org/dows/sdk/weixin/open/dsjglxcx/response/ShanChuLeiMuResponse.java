package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/category-management/deleteCategory.html
 *
 * @author lait.zhang@gmail.com
 * @description 删除类目
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "删除类目Response", title = "删除类目Response")
public class ShanChuLeiMuResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

