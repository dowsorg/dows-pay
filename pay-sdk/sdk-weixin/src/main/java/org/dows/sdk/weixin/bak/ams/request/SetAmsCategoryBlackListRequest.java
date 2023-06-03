package org.dows.sdk.weixin.bak.ams.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-black/SetAmsCategoryBlackList.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "SetAmsCategoryBlackListRequest", title = "SetAmsCategoryBlackListRequest")
public class SetAmsCategoryBlackListRequest {
    @Schema(title = "屏蔽的行业类别。枚举值：CHESS：棋牌游戏；ADULT_SUPPLIES：成人用品；MEDICAL_HEALTH：医疗健康；INSURANCE：保险；SECURITES：证券；LOAN：贷款；LIVING_SERVICES_BEAUTY：生活服务（丽人）；LIVING_SERVICES_ENTERTAIN")
    private String ams_category;
}

