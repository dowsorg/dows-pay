package org.dows.sdk.weixin.bak.ams.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-black/GetAmsCategoryBlackList.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "GetAmsCategoryBlackListResponse", title = "GetAmsCategoryBlackListResponse")
public class GetAmsCategoryBlackListResponse {
    @Schema(title = "错误码")
    private Integer ret;
    @Schema(title = "错误信息")
    private String err_msg;
    @Schema(title = "屏蔽的行业类别，枚举值：CHESS：棋牌游戏，ADULT_SUPPLIES：成人用品，MEDICAL_HEALTH：医疗健康，INSURANCE：保险，SECURITES：证券，LOAN：贷款，LIVING_SERVICES_BEAUTY：生活服务（丽人），LIVING_SERVICES_ENTERTAINMENT：生活服务（休闲娱乐），LIVING_SERVICES_OTHERS：生活服务（其他），FOOD_INDUSTRY：餐饮，RETAIL_AND_GENERAL_MERCHANDISE：零售和百货，FOOD_AND_DRINK：食品饮料，TECHNICAL_SERVICE：通讯与IT服务")
    private String ams_category;
}

