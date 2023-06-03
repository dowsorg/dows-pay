package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/privacy-management/uploadPrivacySetting.html
 *
 * @author lait.zhang@gmail.com
 * @description 上传小程序用户隐私保护指引
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "上传小程序用户隐私保护指引Request", title = "上传小程序用户隐私保护指引Request")
public class ShangChuanXiaoChengXuYongHuYinSiBaoHuZhiYinRequest {
    @Schema(title = "第三方平台接口调用凭证")
    private String access_token;
    @Schema(title = "只支持传txt文件")
    private Bufffer file;

    static class Bufffer {

    }
}

