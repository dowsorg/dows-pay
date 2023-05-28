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
public class SetHeadImageRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "头像素材 media_id")
    private String head_img_media_id;
    @Schema(title = "裁剪框左上角 x 坐标（取值范围：[0, 1]）")
    private String x1;
    @Schema(title = "裁剪框左上角 y 坐标（取值范围：[0, 1]）")
    private String y1;
    @Schema(title = "裁剪框右下角 x 坐标（取值范围：[0, 1]）")
    private String x2;
    @Schema(title = "裁剪框右下角 y 坐标（取值范围：[0, 1]）")
    private String y2;
}

