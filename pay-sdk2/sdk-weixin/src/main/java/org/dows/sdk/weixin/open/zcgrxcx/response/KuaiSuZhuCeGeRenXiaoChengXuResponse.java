package org.dows.sdk.weixin.open1.zcgrxcx.response;

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
@Schema(name = "快速注册个人小程序Response", title = "快速注册个人小程序Response")
public class KuaiSuZhuCeGeRenXiaoChengXuResponse{
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "任务id，后面query查询需要用到")
    private String taskid;
    @Schema(title = "给用户扫码认证的验证url")
    private String authorize_url;
    @Schema(title = "任务的状态")
    private Integer status;
}

