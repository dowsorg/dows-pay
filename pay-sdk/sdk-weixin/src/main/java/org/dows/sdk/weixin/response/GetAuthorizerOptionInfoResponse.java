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
public class GetAuthorizerOptionInfoResponse{
    @Schema(title = "选项名称")
    private String option_name;
    @Schema(title = "选项值")
    private String option_value;
}

