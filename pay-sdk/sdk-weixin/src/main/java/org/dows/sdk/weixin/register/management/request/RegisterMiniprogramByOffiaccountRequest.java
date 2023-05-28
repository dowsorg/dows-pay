package org.dows.sdk.weixin.register.management.request;

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
@Schema(name = "RegisterMiniprogramByOffiaccountRequest", title = "RegisterMiniprogramByOffiaccountRequest")
public class RegisterMiniprogramByOffiaccountRequest{
    @Schema(title = "第三方平台接口调用凭证")
    private String access_token;
    @Schema(title = "公众号扫码授权的凭证(公众平台扫码页面回跳到第三方平台时携带)，要看")
    private String ticket;
}

