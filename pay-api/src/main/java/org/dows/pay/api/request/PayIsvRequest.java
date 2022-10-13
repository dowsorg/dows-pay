package org.dows.pay.api.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.dows.pay.api.BizModel;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.resonse.PayIsvResponse;

import java.util.Map;

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
    private String tenantId;
    @ApiModelProperty("appId")
    private String appId;
    @ApiModelProperty("通道名")
    private String channel;
    @ApiModelProperty("业务方法")
    private String method;

    @ApiModelProperty("json参数体")
    private Map<String, Object> params;
    @ApiModelProperty("业务模型")
    private BizModel bizModel;
    private Class<PayIsvResponse> responseClass;

}
