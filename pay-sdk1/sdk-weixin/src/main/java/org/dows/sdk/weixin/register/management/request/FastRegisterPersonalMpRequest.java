package org.dows.sdk.weixin.register.management.request;

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
public class FastRegisterPersonalMpRequest{
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "个人用户名字")
    private String idname;
    @Schema(title = "个人用户微信号")
    private String wxuser;
    @Schema(title = "第三方联系电话")
    private String component_phone;
}

