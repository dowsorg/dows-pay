package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/category-management/getAllCategoriesByType.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取不同类型主体可设置的类目
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取不同类型主体可设置的类目Request", title = "获取不同类型主体可设置的类目Request")
public class HuoQuBuTongLeiXingZhuTiKeSheZhiDeLeiMuRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "如果不填，默认传0；个人主体是0；企业主体是1；政府是2；媒体是3；其他组织是4")
    private Integer verify_type;
}

