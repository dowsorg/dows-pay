package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/uploadMediaToCodeAudit.html
 *
 * @author lait.zhang@gmail.com
 * @description 上传提审素材
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "上传提审素材Request", title = "上传提审素材Request")
public class ShangChuanTiShenSuCaiRequest {
    @Schema(title = "第三方平台接口调用凭证")
    private String access_token;
    @Schema(title = "图片（image）: 2M，支持PNG\\JPEG\\JPG\\GIF格式 视频（video）：10MB，支持MP4格式 完成素材上传后，使用返回的mediaid，可以在提审接口通过post preview_info完成图片和视频上传。 注意：返回的 mediaid 有效期是三天，过期需要重新上传")
    private Formdata media;

    static class Formdata {

    }
}

