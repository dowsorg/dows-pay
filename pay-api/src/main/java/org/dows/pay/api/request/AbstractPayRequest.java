package org.dows.pay.api.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.PayResponse;
import org.dows.pay.api.annotation.ParamName;

import java.util.Map;

@Data
public abstract class AbstractPayRequest<T extends PayResponse> implements PayRequest<T> {

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
    private Map<String, Object> params;

    @ApiModelProperty("json参数体")
    @ParamName("biz_params")
    private String bizContent;

    private Class<T> responseClass;
}
