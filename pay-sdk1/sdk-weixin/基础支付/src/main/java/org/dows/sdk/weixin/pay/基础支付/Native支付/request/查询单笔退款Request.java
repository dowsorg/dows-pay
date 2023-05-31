package org.dows.sdk.weixin.pay.基础支付.Native支付.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_4_10.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年5月31日 上午11:18:23
 */
@Data
@Schema(name = "查询单笔退款Request", title = "查询单笔退款Request")
public class 查询单笔退款Request{
    @Schema(title = "")
    private String[1, 64] 商户退款单号;
}

