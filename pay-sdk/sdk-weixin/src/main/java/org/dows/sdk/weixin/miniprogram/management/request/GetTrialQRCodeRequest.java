package org.dows.sdk.weixin.miniprogram.management.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;

/**
 *
 * @description 
 * @author @author lait.zhang@gmail.com
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "GetTrialQRCodeRequest", title = "GetTrialQRCodeRequest")
public class GetTrialQRCodeRequest{
    @Schema(title = "第三方平台接口调用凭证")
    private String access_token;
    @Schema(title = "指定二维码扫码后直接进入指定页面并可同时带上参数")
    private String path;
}

