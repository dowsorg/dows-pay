package org.dows.sdk.weixin.pay.基础支付.H5支付.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_10.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年5月31日 下午9:40:07
 */
@Data
@Schema(name = "查询单笔退款Request", title = "查询单笔退款Request")
public class 查询单笔退款Request{
    @Schema(title = "")
    private String[1,32] 受理类型;
    @Schema(title = "")
    private String[5, 32] 商家转账批次单号;
    @Schema(title = "")
    private String[5, 32] 商家转账明细单号;
}

