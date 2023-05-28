package org.dows.sdk.weixin.miniprogram.management.request;

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
public class WeDataSetLoginConfigRequest{
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "1: 配置反查地址 ; 2:配置关联appid")
    private Integer set_type;
    @Schema(title = "反查地址，set_type =1时生效，若为空表示删除")
    private String recheck_url;
    @Schema(title = "关联appid，set_type=2时生效，若为空表示删除")
    private List<String> associate_appid;
}

