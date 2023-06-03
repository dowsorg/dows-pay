package org.dows.sdk.weixin.open.ptdykf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/scf-management/getCodeSecret.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取代码保护密钥
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取代码保护密钥Response", title = "获取代码保护密钥Response")
public class HuoQuDaiMaBaoHuMiYaoResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "代码保护密钥")
    private String codesecret;
}

