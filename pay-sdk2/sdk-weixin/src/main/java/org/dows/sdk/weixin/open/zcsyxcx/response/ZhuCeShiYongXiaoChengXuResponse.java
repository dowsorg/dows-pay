package org.dows.sdk.weixin.open1.zcsyxcx.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/register-management/fast-regist-beta/registerBetaMiniprogram.html
 * @description 注册试用小程序
 * @author lait.zhang@gmail.com
 * @date 2023年6月2日 下午4:54:46
 */
@Data
@Schema(name = "注册试用小程序Response", title = "注册试用小程序Response")
public class ZhuCeShiYongXiaoChengXuResponse{
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "该请求的唯一标识符，用于关联微信用户和后面产生的appid")
    private String unique_id;
    @Schema(title = "用户授权确认url，需将该url发送给用户，小程序管理员在微信打开并进入授权页面完成授权方可创建小程序")
    private String authorize_url;
}

