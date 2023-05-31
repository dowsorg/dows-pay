package org.dows.sdk.weixin.pay.基础支付.小程序支付.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_5_6.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年5月31日 下午9:40:07
 */
@Data
@Schema(name = "申请交易账单Request", title = "申请交易账单Request")
public class 申请交易账单Request{
    @Schema(title = "")
    private String[1,10] 账单日期;
    @Schema(title = "")
    private String[1,32] 账单类型;
    @Schema(title = "")
    private String[1,32] 压缩类型;
}

