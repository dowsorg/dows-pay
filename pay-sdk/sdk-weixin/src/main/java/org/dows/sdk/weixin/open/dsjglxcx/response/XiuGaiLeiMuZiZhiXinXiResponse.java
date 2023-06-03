package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/category-management/modifyCategory.html
 *
 * @author lait.zhang@gmail.com
 * @description 修改类目资质信息
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "修改类目资质信息Response", title = "修改类目资质信息Response")
public class XiuGaiLeiMuZiZhiXinXiResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

