package org.dows.sdk.weixin.ams.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;

/**
 *
 * @description 
 * @author @author lait.zhang@gmail.com
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "SetAmsCategoryBlackListRequest", title = "SetAmsCategoryBlackListRequest")
public class SetAmsCategoryBlackListRequest{
    @Schema(title = "屏蔽的行业类别。枚举值：CHESS：棋牌游戏；ADULT_SUPPLIES：成人用品；MEDICAL_HEALTH：医疗健康；INSURANCE：保险；SECURITES：证券；LOAN：贷款；LIVING_SERVICES_BEAUTY：生活服务（丽人）；LIVING_SERVICES_ENTERTAIN")
    private String ams_category;
}

