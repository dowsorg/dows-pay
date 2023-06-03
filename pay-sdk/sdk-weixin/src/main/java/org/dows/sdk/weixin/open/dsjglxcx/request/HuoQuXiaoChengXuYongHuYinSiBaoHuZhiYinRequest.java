package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/privacy-management/getPrivacySetting.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取小程序用户隐私保护指引
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取小程序用户隐私保护指引Request", title = "获取小程序用户隐私保护指引Request")
public class HuoQuXiaoChengXuYongHuYinSiBaoHuZhiYinRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "1表示现网版本，即，传1则该接口返回的内容是现网版本的；2表示开发版，即，传2则该接口返回的内容是开发版本的。默认是2。")
    private Integer privacy_ver;
}

