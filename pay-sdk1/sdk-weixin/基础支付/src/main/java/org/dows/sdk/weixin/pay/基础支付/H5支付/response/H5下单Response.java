package org.dows.sdk.weixin.pay.基础支付.H5支付.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_1.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年5月31日 上午11:18:23
 */
@Data
@Schema(name = "H5下单Response", title = "H5下单Response")
public class H5下单Response{
    @Schema(title = "商户系统内部的商家批次单号")
    private String[1,32] 商家批次单号;
    @Schema(title = "微信批次单号，微信商家转账系统返回的唯一标识")
    private String[1,64] 微信批次单号;
    @Schema(title = "批次受理成功时返回，遵循")
    private String[1,32] 批次创建时间;
}

