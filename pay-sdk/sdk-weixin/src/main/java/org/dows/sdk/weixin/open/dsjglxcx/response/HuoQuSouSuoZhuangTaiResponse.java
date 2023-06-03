package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/getSearchStatus.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取搜索状态
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取搜索状态Response", title = "获取搜索状态Response")
public class HuoQuSouSuoZhuangTaiResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "1 表示不可搜索，0 表示可搜索")
    private Integer status;
}

