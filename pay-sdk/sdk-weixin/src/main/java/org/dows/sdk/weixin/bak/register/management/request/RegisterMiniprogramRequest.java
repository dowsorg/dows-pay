package org.dows.sdk.weixin.bak.register.management.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/register-management/fast-registration-ent/registerMiniprogram.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "RegisterMiniprogramRequest", title = "RegisterMiniprogramRequest")
public class RegisterMiniprogramRequest {
    @Schema(title = "第三方平台接口调用凭证")
    private String access_token;
    @Schema(title = "企业名（需与工商部门登记信息一致）；如果是“无主体名称个体工商户”则填“个体户+法人姓名”，例如“个体户张三”")
    private String name;
    @Schema(title = "企业代码")
    private String code;
    @Schema(title = "企业代码类型 1：统一社会信用代码（18 位） 2：组织机构代码（9 位 xxxxxxxx-x） 3：营业执照注册号(15 位)")
    private Integer code_type;
    @Schema(title = "法人微信号")
    private String legal_persona_wechat;
    @Schema(title = "法人姓名（绑定银行卡）")
    private String legal_persona_name;
    @Schema(title = "第三方联系电话")
    private String component_phone;
}

