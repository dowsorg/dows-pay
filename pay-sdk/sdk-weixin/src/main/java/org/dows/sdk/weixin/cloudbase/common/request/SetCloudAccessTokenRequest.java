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
public class SetCloudAccessTokenRequest{
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "可选get或者set")
    private String action;
    @Schema(title = "true表示开启，false表示关闭。全局配置，action=set时必填。")
    private Boolean open;
    @Schema(title = "api白名单，action=set时必填。")
    private List<String> api_whitelist;
    @Schema(title = "环境 id , 白名单为环境维度配置")
    private String env;
    @Schema(title = "版本号，action=set时必填")
    private Integer version;

}
