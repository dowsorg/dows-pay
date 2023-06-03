package org.dows.sdk.weixin.pay.jsapizf.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_1_3.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年6月3日 上午9:06:55
 */
@Data
@Schema(name = "关闭订单Request", title = "关闭订单Request")
public class GuanBiDingDanRequest{
    @Schema(title = "")
    private String sp_mchid;
    @Schema(title = "")
    private String sub_mchid;
    @Schema(title = "")
    private String out_trade_no;
}

