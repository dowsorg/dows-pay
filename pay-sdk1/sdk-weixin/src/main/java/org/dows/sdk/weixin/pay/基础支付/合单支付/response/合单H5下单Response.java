package org.dows.sdk.weixin.pay.基础支付.合单支付.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_2.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年5月31日 下午9:40:07
 */
@Data
@Schema(name = "合单H5下单Response", title = "合单H5下单Response")
public class 合单H5下单Response{
    @Schema(title = "支付跳转链接，h5_url的有效期为5分钟")
    private String[1,512] 支付跳转链接;
}

