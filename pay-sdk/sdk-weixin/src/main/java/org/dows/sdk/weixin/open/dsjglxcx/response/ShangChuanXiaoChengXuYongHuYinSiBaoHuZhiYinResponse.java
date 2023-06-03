package org.dows.sdk.weixin.open.dsjglxcx.response;

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
@Schema(name = "上传小程序用户隐私保护指引Response", title = "上传小程序用户隐私保护指引Response")
public class ShangChuanXiaoChengXuYongHuYinSiBaoHuZhiYinResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "文件的media_id")
    private String ext_file_media_id;
}

