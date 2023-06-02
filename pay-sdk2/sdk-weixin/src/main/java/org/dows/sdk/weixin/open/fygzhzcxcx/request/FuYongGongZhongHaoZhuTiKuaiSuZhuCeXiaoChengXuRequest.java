package org.dows.sdk.weixin.open.fygzhzcxcx.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/register-management/fast-registration-officalaccount/registerMiniprogramByOffiaccount.html
 * @description 复用公众号主体快速注册小程序
 * @author lait.zhang@gmail.com
 * @date 2023年6月2日 下午4:54:46
 */
@Data
@Schema(name = "复用公众号主体快速注册小程序Request", title = "复用公众号主体快速注册小程序Request")
public class FuYongGongZhongHaoZhuTiKuaiSuZhuCeXiaoChengXuRequest{
    @Schema(title = "第三方平台接口调用凭证")
    private String access_token;
    @Schema(title = "公众号扫码授权的凭证(公众平台扫码页面回跳到第三方平台时携带)，要看")
    private String ticket;
}

