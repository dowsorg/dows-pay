package org.dows.sdk.weixin.cloudbase.batch.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;

/**
 *
 * @description 
 * @author @author lait.zhang@gmail.com
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "InvokeCloudFunctionRequest", title = "InvokeCloudFunctionRequest")
public class InvokeCloudFunctionRequest{
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "云开发环境ID")
    private String env;
    @Schema(title = "云函数名称")
    private String name;
    @Schema(title = "云函数的传入参数，具体结构由开发者定义")
    private String req_data;
}

