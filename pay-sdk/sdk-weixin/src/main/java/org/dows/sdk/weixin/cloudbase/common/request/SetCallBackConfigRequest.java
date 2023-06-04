package org.dows.sdk.weixin.cloudbase.common.request;

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
@NoArgsConstructor
public class SetCallBackConfigRequest{
    @Schema(title = "¥ÌŒÛ¬Î")
    private Integer errcode;
    @Schema(title = "¥ÌŒÛ–≈œ¢")
    private String errmsg;

}
