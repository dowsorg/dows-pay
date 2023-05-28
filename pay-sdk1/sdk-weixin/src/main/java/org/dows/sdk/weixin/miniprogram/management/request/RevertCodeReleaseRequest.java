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
public class RevertCodeReleaseRequest{
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "只能填get_history_version。表示获取可回退的小程序版本。该参数为 URL 参数，非 Body 参数。")
    private String action;
    @Schema(title = "默认是回滚到上一个版本；也可回滚到指定的小程序版本，可通过get_history_version获取app_version。该参数为 URL 参数，非 Body 参数。")
    private String app_version;
}

