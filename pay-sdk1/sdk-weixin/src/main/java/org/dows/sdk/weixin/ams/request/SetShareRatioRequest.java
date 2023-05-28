package org.dows.sdk.weixin.ams.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;

/**
* @description 
*
* @author 
* @date 
*/
@Data
public class SetShareRatioRequest{
    @Schema(title = "服务商默认分账比例。如share_ratio为40，则代表服务商获得收益的40%，小程序商家获得收益的60%")
    private Integer share_ratio;
}

