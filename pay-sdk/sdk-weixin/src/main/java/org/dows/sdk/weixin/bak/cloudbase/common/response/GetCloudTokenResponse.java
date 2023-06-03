package org.dows.sdk.weixin.bak.cloudbase.common.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/admin-management/getCloudToken.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "GetCloudTokenResponse", title = "GetCloudTokenResponse")
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

