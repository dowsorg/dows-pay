package org.dows.sdk.weixin.miniprogram.management.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author
 * @description
 * @date 2023年5月28日 下午9:25:34
 * @date
 */
@Data
public class UploadMediaToCodeAuditRequest {
    @Schema(title = "第三方平台接口调用凭证")
    private String access_token;
    @Schema(title = "图片（image）: 2M，支持PNG\\JPEG\\JPG\\GIF格式 视频（video）：10MB，支持MP4格式 完成素材上传后，使用返回的mediaid，可以在提审接口通过post preview_info完成图片和视频上传。 注意：返回的 mediaid 有效期是三天，过期需要重新上传")
    private Formdata media;
}

