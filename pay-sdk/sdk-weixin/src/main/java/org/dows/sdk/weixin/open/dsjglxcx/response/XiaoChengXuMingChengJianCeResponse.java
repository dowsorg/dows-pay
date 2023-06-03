package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/checkNickName.html
 *
 * @author lait.zhang@gmail.com
 * @description 小程序名称检测
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "小程序名称检测Response", title = "小程序名称检测Response")
public class XiaoChengXuMingChengJianCeResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "是否命中关键字策略。若命中，可以选填关键字材料")
    private Boolean hit_condition;
    @Schema(title = "命中关键字的说明描述")
    private String wording;
}

