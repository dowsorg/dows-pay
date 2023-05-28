package org.dows.sdk.weixin.cloudbase.batch.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author
 * @description
 * @date 2023年5月28日 下午9:25:34
 * @date
 */
@Data
public class SetCloudAccessTokenResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "开启/关闭，action=get时返回")
    private Boolean open;
    @Schema(title = "api白名单，action=get时返回")
    private List<String> api_whitelist;
    @Schema(title = "版本号，action=get时返回")
    private Integer version;
}

