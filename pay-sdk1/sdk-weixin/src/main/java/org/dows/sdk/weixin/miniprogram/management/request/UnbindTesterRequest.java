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
public class UnbindTesterRequest{
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "微信号。 userstr 和 wechatid 填写其中一个即可")
    private String wechatid;
    @Schema(title = "人员对应的唯一字符串， 可通过getTester接口获取人员对应的字符串")
    private String userstr;
}

