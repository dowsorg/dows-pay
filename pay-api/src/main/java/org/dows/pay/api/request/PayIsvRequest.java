package org.dows.pay.api.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.annotation.ParamName;
import org.dows.pay.api.resonse.PayIsvResponse;

@Data
@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "PayIsvRequest对象", description = "代理商请求对象")
public class PayIsvRequest implements PayRequest<PayIsvResponse> {
    @ApiModelProperty("租户或商户编号")
    @ParamName("tenantId")
    private String tenantId;
    @ApiModelProperty("appId")
    @ParamName("appId")
    private String appId;
    @ApiModelProperty("通道名")
    @ParamName("channel")
    private String channel;
    @ApiModelProperty("业务方法")
    @ParamName("biz_method")
    private String method;
    @ApiModelProperty("json参数体")
    @ParamName("biz_params")
    private String params;
    private Class<PayIsvResponse> responseClass;

}
