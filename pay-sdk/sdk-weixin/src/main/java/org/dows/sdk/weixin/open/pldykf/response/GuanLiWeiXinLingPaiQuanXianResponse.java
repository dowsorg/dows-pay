package org.dows.sdk.weixin.open.pldykf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/env-mgnt/setCloudAccessToken.html
 *
 * @author lait.zhang@gmail.com
 * @description 管理微信令牌权限
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "管理微信令牌权限Response", title = "管理微信令牌权限Response")
public class GuanLiWeiXinLingPaiQuanXianResponse {
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

