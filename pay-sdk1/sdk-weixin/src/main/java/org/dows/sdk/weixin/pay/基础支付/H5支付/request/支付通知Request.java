package org.dows.sdk.weixin.pay.基础支付.H5支付.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_5.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年5月31日 下午9:40:07
 */
@Data
@Schema(name = "支付通知Request", title = "支付通知Request")
public class 支付通知Request{
    @Schema(title = "")
    private String[1,32] 商家批次单号;
    @Schema(title = "")
    private Boolean 是否查询转账明细单;
    @Schema(title = "")
    private Int 请求资源起始位置;
    @Schema(title = "")
    private Int 最大资源条数;
    @Schema(title = "")
    private String[1,32] 明细状态;
}

