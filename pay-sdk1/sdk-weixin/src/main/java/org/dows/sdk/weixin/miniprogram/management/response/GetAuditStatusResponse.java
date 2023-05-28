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
public class GetAuditStatusResponse{
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "审核状态")
    private Integer status;
    @Schema(title = "当 status = 1 时，返回的拒绝原因; status = 4 时，返回的延后原因")
    private String reason;
    @Schema(title = "当 status = 1 时，会返回审核失败的小程序截图示例。用")
    private String screenshot;
}

