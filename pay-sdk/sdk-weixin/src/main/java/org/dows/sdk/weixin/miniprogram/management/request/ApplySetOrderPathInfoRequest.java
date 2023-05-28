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
public class ApplySetOrderPathInfoRequest {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "返回码信息")
    private String errmsg;
}

