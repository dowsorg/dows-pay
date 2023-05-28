package org.dows.sdk.weixin.cloudbase.common.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author
 * @description
 * @date 2023年5月28日 下午9:25:34
 * @date
 */
@Data
public class GetCloudTokenResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "secretid")
    private String secretid;
    @Schema(title = "secretkey")
    private String secretkey;
    @Schema(title = "token")
    private String token;
    @Schema(title = "过期时间戳")
    private Integer expired_time;
}

