package org.dows.sdk.weixin.open.ptdykf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/admin-management/getCloudToken.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取腾讯云API调用凭证
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取腾讯云API调用凭证Response", title = "获取腾讯云API调用凭证Response")
public class HuoQuTengXunYunAPIDiaoYongPingZhengResponse {
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

