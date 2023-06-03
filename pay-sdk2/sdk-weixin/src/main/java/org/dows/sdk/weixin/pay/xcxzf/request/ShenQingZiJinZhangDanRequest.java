package org.dows.sdk.weixin.pay.xcxzf.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_5_7.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年6月3日 上午9:06:55
 */
@Data
@Schema(name = "申请资金账单Request", title = "申请资金账单Request")
public class ShenQingZiJinZhangDanRequest{
    @Schema(title = "")
    private String bill_date;
    @Schema(title = "")
    private String account_type;
    @Schema(title = "")
    private String tar_type;
}

