package org.dows.sdk.weixin.bak.miniprogram.management.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/checkNickName.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "CheckNickNameResponse", title = "CheckNickNameResponse")
public class CheckNickNameResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "是否命中关键字策略。若命中，可以选填关键字材料")
    private Boolean hit_condition;
    @Schema(title = "命中关键字的说明描述")
    private String wording;
}

