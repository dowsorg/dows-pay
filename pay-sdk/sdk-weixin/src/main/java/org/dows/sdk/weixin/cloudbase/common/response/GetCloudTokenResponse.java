package org.dows.sdk.weixin.cloudbase.common.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @description
 * @date
 */
@Data
@NoArgsConstructor
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
