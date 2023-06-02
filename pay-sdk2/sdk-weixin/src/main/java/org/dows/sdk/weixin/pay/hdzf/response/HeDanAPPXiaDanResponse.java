package org.dows.sdk.weixin.pay.hdzf.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_1.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年6月2日 下午5:32:39
 */
@Data
@Schema(name = "合单APP下单Response", title = "合单APP下单Response")
public class HeDanAPPXiaDanResponse{
    @Schema(title = "数字和字母。微信生成的预支付会话标识，用于后续接口调用使用，该值有效期为2小时。")
    private String prepay_id;
}

