package org.dows.sdk.weixin.pay.h5zf.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_2.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年6月2日 下午5:32:38
 */
@Data
@Schema(name = "查询订单Request", title = "查询订单Request")
public class ChaXunDingDanRequest{
    @Schema(title = "")
    private String batch_id;
    @Schema(title = "")
    private Boolean need_query_detail;
    @Schema(title = "")
    private Int offset;
    @Schema(title = "")
    private Int limit;
    @Schema(title = "")
    private String detail_status;
}

