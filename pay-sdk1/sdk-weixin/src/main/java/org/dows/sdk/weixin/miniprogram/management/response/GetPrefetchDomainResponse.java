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
public class GetPrefetchDomainResponse{
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "预解析dns域名")
    private Array.<object> prefetch_dns_domain;
    @Schema(title = "总共可配置域名个数")
    private Integer size_limit;
}

