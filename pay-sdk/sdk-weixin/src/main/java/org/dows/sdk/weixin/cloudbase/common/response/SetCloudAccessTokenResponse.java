package org.dows.sdk.weixin.cloudbase.common.response;

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
public class SetCloudAccessTokenResponse{
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "开启/关闭，action=get时返回")
    private Boolean open;
    @Schema(title = "api白名单，action=get时返回")
    private List<String> api_whitelist;
    @Schema(title = "版本号，action=get时返回")
    private Integer version;

}
