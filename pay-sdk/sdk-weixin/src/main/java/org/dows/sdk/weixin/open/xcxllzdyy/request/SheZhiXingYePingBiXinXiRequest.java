package org.dows.sdk.weixin.open.xcxllzdyy.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-black/SetAmsCategoryBlackList.html
 *
 * @author lait.zhang@gmail.com
 * @description 设置行业屏蔽信息
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "设置行业屏蔽信息Request", title = "设置行业屏蔽信息Request")
public class SheZhiXingYePingBiXinXiRequest {
    @Schema(title = "屏蔽的行业类别。枚举值：CHESS：棋牌游戏；ADULT_SUPPLIES：成人用品；MEDICAL_HEALTH：医疗健康；INSURANCE：保险；SECURITES：证券；LOAN：贷款；LIVING_SERVICES_BEAUTY：生活服务（丽人）；LIVING_SERVICES_ENTERTAIN")
    private String ams_category;
}

