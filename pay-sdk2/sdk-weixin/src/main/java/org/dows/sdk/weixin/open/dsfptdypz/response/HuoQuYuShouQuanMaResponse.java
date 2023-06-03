package org.dows.sdk.weixin.open1.dsfptdypz.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ticket-token/getPreAuthCode.html
 * @description 获取预授权码
 * @author lait.zhang@gmail.com
 * @date 2023年6月2日 下午4:54:46
 */
@Data
@Schema(name = "获取预授权码Response", title = "获取预授权码Response")
public class HuoQuYuShouQuanMaResponse{
    @Schema(title = "预授权码")
    private String pre_auth_code;
    @Schema(title = "有效期，单位：秒")
    private Integer expires_in;
}

