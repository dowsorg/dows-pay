package org.dows.sdk.weixin.miniprogram.management.response;

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
public class SetCodeAuditQuotaResponse{
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "quota剩余值")
    private Integer rest;
    @Schema(title = "当月分配quota")
    private Integer limit;
    @Schema(title = "剩余加急次数")
    private Integer speedup_rest;
    @Schema(title = "当月分配加急次数")
    private Integer speedup_limit;
}

