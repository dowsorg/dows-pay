package org.dows.sdk.weixin.cloudbase.batch.request;

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
public class DbrecordManageRequest{
    @Schema(title = "")
    private String access_token;
    @Schema(title = "填insert")
    private String action;
    @Schema(title = "云环境ID")
    private String env;
    @Schema(title = "数据库操作语句")
    private String query;
}

