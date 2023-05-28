package org.dows.sdk.weixin.thirdparty.management.request;

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
public class AddToTemplateRequest{
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "草稿 ID")
    private Integer draft_id;
    @Schema(title = "默认值是0，对应普通模板；可选1，对应标准模板库，关于标准模板库和普通模板库的区别可以查看")
    private Integer template_type;
}

