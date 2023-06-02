package org.dows.sdk.weixin.open.openApigl.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/openapi/getApiQuota.html
 * @description 查询API调用额度
 * @author lait.zhang@gmail.com
 * @date 2023年6月2日 下午4:54:46
 */
@Data
@Schema(name = "查询API调用额度Request", title = "查询API调用额度Request")
public class ChaXunAPIDiaoYongEDuRequest{
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "api的请求地址，例如'/cgi-bin/message/custom/send';不要前缀“https://api.weixin.qq.com” ，也不要漏了'/',否则都会76003的报错")
    private String cgi_path;
}

