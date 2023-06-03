package org.dows.sdk.weixin.open.dsjglxcx.request;

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
@Schema(name = "修改头像Request", title = "修改头像Request")
public class XiuGaiTouXiangRequest {
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

