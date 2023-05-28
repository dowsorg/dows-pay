package org.dows.sdk.weixin.response;

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
public class GetAuthorizerInfoResponse{
    @Schema(title = "订阅号")
    private 0 ;
    @Schema(title = "由历史老帐号升级后的订阅号")
    private 1 ;
    @Schema(title = "服务号")
    private 2 ;
}

