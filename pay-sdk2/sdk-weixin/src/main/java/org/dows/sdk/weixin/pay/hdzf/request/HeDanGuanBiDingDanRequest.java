package org.dows.sdk.weixin.pay.hdzf.request;

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
 * @date 2023年6月3日 上午9:06:55
 */
@Data
@Schema(name = "合单关闭订单Request", title = "合单关闭订单Request")
public class HeDanGuanBiDingDanRequest{
    @Schema(title = "")
    private String combine_appid;
    @Schema(title = "")
    private String combine_out_trade_no;
    @Schema(title = "")
    private Array sub_orders;
    @Schema(title = "子单发起方商户号，必须与发起方appid有绑定关系。")
    private String mchid;
    @Schema(title = "商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。")
    private String out_trade_no;
}

