package org.dows.sdk.weixin.open.dsfptgl.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/thirdparty-management/template-management/deleteTemplate.html
 *
 * @author lait.zhang@gmail.com
 * @description 删除代码模板
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "删除代码模板Request", title = "删除代码模板Request")
public class ShanChuDaiMaMoBanRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "要删除的模板 ID ，可通过获取模板列表接口（https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/2.0/api/ThirdParty/code_template/gettemplatelist.html）获取。")
    private Integer template_id;
}

