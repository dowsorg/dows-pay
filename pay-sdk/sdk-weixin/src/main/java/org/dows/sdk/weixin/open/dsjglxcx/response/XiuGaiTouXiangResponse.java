package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/setHeadImage.html
 *
 * @author lait.zhang@gmail.com
 * @description 修改头像
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "修改头像Response", title = "修改头像Response")
public class XiuGaiTouXiangResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

