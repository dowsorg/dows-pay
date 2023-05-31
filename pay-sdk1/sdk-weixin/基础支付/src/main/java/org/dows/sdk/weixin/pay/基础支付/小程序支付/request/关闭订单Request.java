package org.dows.sdk.weixin.pay.基础支付.小程序支付.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_5_3.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年5月31日 上午11:18:23
 */
@Data
@Schema(name = "关闭订单Request", title = "关闭订单Request")
public class 关闭订单Request{
    @Schema(title = "")
    private String[1,32] 服务商户号;
    @Schema(title = "")
    private String[1,32] 子商户号;
    @Schema(title = "")
    private String[1,32] 商户订单号;
}

