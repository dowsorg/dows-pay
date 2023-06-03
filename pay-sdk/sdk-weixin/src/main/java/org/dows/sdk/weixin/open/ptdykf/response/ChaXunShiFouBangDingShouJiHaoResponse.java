package org.dows.sdk.weixin.open.ptdykf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/admin-management/checkMobileConfig.html
 *
 * @author lait.zhang@gmail.com
 * @description 查询是否绑定手机号
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "查询是否绑定手机号Response", title = "查询是否绑定手机号Response")
public class ChaXunShiFouBangDingShouJiHaoResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "是否绑定了手机号")
    private Boolean has_mobile;
}

