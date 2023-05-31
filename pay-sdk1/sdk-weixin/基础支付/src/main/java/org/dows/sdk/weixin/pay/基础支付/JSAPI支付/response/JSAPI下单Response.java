package org.dows.sdk.weixin.pay.基础支付.JSAPI支付.response;

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
 * @date 2023年5月31日 下午2:46:10
 */
@Data
@Schema(name = "JSAPI下单Response", title = "JSAPI下单Response")
public class JSAPI下单Response{
    @Schema(title = "预支付交易会话标识。用于后续接口调用中使用，该值有效期为2小时")
    private String[1,64] 预支付交易会话标识;
}

