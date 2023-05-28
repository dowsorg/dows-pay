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
public class GetNickNameStatusResponse{
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "审核昵称")
    private String nickname;
    @Schema(title = "审核状态，1：审核中，2：审核失败，3：审核成功")
    private Integer audit_stat;
    @Schema(title = "失败原因")
    private String fail_reason;
    @Schema(title = "审核提交时间")
    private Integer create_time;
    @Schema(title = "审核完成时间")
    private Integer audit_time;
}

