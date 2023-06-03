package org.dows.sdk.weixin.open.dsjglxcx.request;

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
@Schema(name = "修改类目资质信息Request", title = "修改类目资质信息Request")
public class XiuGaiLeiMuZiZhiXinXiRequest {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

