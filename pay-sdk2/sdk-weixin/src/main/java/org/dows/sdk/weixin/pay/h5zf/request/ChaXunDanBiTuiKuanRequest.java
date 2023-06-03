package org.dows.sdk.weixin.pay.h5zf.request;

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
 * @date 2023年6月3日 上午9:06:55
 */
@Data
@Schema(name = "查询单笔退款Request", title = "查询单笔退款Request")
public class ChaXunDanBiTuiKuanRequest{
    @Schema(title = "")
    private String accept_type;
    @Schema(title = "")
    private String out_batch_no;
    @Schema(title = "")
    private String out_detail_no;
}

