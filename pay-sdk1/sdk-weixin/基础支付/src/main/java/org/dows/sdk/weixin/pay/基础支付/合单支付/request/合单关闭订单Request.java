package org.dows.sdk.weixin.pay.基础支付.合单支付.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_12.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年5月31日 上午11:18:23
 */
@Data
@Schema(name = "合单关闭订单Request", title = "合单关闭订单Request")
public class 合单关闭订单Request{
    @Schema(title = "")
    private String[1,32] 合单商户appid;
    @Schema(title = "")
    private String[1,32] 合单商户订单号;
    @Schema(title = "")
    private Array ;
    @Schema(title = "子单发起方商户号，必须与发起方appid有绑定关系。")
    private String[1,32] 子单商户号;
    @Schema(title = "商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。")
    private String[6,32] 子单商户订单号;
}

