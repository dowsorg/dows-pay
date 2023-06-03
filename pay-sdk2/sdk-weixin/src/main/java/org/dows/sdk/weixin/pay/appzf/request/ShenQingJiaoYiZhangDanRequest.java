package org.dows.sdk.weixin.pay.appzf.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_2_6.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年6月3日 上午9:06:55
 */
@Data
@Schema(name = "申请交易账单Request", title = "申请交易账单Request")
public class ShenQingJiaoYiZhangDanRequest{
    @Schema(title = "")
    private String bill_date;
    @Schema(title = "")
    private String bill_type;
    @Schema(title = "")
    private String tar_type;
}

