package org.dows.sdk.weixin.miniprogram.management.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @description
 * @date
 */
@Data
@NoArgsConstructor
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
