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
public class DbcollectionManageRequest{
    @Schema(title = "")
    private String access_token;
    @Schema(title = "填'get'")
    private String action;
    @Schema(title = "环境ID")
    private String env;
    @Schema(title = "返回数据长度")
    private Integer limit;
    @Schema(title = "数据偏移量")
    private Integer offset;
}

