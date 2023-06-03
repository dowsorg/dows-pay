package org.dows.sdk.weixin.open1.zcqyxcx.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/register-management/fast-registration-ent/registerMiniprogram.html
 * @description 快速注册企业小程序
 * @author lait.zhang@gmail.com
 * @date 2023年6月2日 下午4:54:46
 */
@Data
@Schema(name = "快速注册企业小程序Request", title = "快速注册企业小程序Request")
public class KuaiSuZhuCeQiYeXiaoChengXuRequest{
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

