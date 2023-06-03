package org.dows.sdk.weixin.open1.zcgrxcx.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/register-management/fast-registration-ind/fastRegisterPersonalMp.html
 * @description 快速注册个人小程序
 * @author lait.zhang@gmail.com
 * @date 2023年6月2日 下午4:54:46
 */
@Data
@Schema(name = "快速注册个人小程序Request", title = "快速注册个人小程序Request")
public class KuaiSuZhuCeGeRenXiaoChengXuRequest{
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "个人用户名字")
    private String idname;
    @Schema(title = "个人用户微信号")
    private String wxuser;
    @Schema(title = "第三方联系电话")
    private String component_phone;
}

