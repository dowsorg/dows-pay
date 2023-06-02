package org.dows.sdk.weixin.open.kfptzhgl.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/openplatform-management/createOpenAccount.html
 * @description 创建开放平台帐号
 * @author lait.zhang@gmail.com
 * @date 2023年6月2日 下午4:54:46
 */
@Data
@Schema(name = "创建开放平台帐号Response", title = "创建开放平台帐号Response")
public class ChuangJianKaiFangPingTaiZhangHaoResponse{
    @Schema(title = "所创建的开放平台帐号的 appid")
    private String open_appid;
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

