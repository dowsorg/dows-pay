package org.dows.sdk.weixin.bak.miniprogram.management.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/applySetOrderPathInfo.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "ApplySetOrderPathInfoRequest", title = "ApplySetOrderPathInfoRequest")
public class ApplySetOrderPathInfoRequest {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "返回码信息")
    private String errmsg;
}

