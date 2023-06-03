package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/setSearchStatus.html
 *
 * @author lait.zhang@gmail.com
 * @description 设置搜索状态
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "设置搜索状态Request", title = "设置搜索状态Request")
public class SheZhiSouSuoZhuangTaiRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "1 表示不可搜索，0 表示可搜索")
    private Integer status;
}

