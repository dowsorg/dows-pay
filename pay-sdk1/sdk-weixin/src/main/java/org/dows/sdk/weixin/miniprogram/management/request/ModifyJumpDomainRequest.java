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
public class ModifyJumpDomainRequest{
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "操作类型，如果没有指定 action，则默认将第三方平台登记的小程序业务域名全部添加到该小程序")
    private String action;
    @Schema(title = "小程序业务域名，当 action 参数是 get 时不需要此字段")
    private List<String> webviewdomain;
}

