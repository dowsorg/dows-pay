package org.dows.sdk.weixin.open.ptdykf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/scf-management/getYploadSignature.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取上传凭证
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取上传凭证Response", title = "获取上传凭证Response")
public class HuoQuShangChuanPingZhengResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "带签名headers")
    private String headers;
}

