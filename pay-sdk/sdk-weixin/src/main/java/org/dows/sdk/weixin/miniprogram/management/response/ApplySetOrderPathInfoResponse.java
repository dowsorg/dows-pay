package org.dows.sdk.weixin.miniprogram.management.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "ApplySetOrderPathInfoResponse", title = "ApplySetOrderPathInfoResponse")
public class ApplySetOrderPathInfoResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "返回码信息")
    private String errmsg;
}

