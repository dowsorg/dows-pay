package org.dows.sdk.weixin.pay.jsapizf.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_1_1.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年6月2日 下午5:32:38
 */
@Data
@Schema(name = "JSAPI下单Response", title = "JSAPI下单Response")
public class JSAPIXiaDanResponse{
    @Schema(title = "预支付交易会话标识。用于后续接口调用中使用，该值有效期为2小时")
    private String prepay_id;
}

