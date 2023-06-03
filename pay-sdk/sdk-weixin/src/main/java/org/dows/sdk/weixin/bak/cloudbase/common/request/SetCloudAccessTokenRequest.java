package org.dows.sdk.weixin.bak.cloudbase.common.request;

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
@Schema(name = "SetCloudAccessTokenRequest", title = "SetCloudAccessTokenRequest")
public class SetCloudAccessTokenRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "可选get或者set")
    private String action;
    @Schema(title = "true表示开启，false表示关闭。全局配置，action=set时必填。")
    private Boolean open;
    @Schema(title = "api白名单，action=set时必填。")
    private List<String> api_whitelist;
    @Schema(title = "环境 id , 白名单为环境维度配置")
    private String env;
    @Schema(title = "版本号，action=set时必填")
    private Integer version;
}

