package org.dows.sdk.weixin.ams.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author
 * @description
 * @date 2023年5月28日 下午9:25:34
 * @date
 */
@Data
public class SetAmsCategoryBlackListRequest {
    @Schema(title = "屏蔽的行业类别。枚举值：CHESS：棋牌游戏；ADULT_SUPPLIES：成人用品；MEDICAL_HEALTH：医疗健康；INSURANCE：保险；SECURITES：证券；LOAN：贷款；LIVING_SERVICES_BEAUTY：生活服务（丽人）；LIVING_SERVICES_ENTERTAIN")
    private String ams_category;
}

