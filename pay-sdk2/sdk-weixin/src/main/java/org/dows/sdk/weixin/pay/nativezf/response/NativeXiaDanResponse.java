package org.dows.sdk.weixin.pay.nativezf.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_4_1.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年6月3日 上午9:06:55
 */
@Data
@Schema(name = "Native下单Response", title = "Native下单Response")
public class NativeXiaDanResponse{
    @Schema(title = "此URL用于生成支付二维码，然后提供给用户扫码支付。")
    private String code_url;
}

