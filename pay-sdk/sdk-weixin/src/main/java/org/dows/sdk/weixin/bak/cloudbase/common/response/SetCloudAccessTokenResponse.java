package org.dows.sdk.weixin.bak.cloudbase.common.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/admin-management/setCloudAccessToken.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "SetCloudAccessTokenResponse", title = "SetCloudAccessTokenResponse")
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

