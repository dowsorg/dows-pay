package org.dows.sdk.weixin.open.dsjglxcx.request;

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
@Schema(name = "小程序名称检测Request", title = "小程序名称检测Request")
public class XiaoChengXuMingChengJianCeRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "名称（昵称）")
    private String nick_name;
}

