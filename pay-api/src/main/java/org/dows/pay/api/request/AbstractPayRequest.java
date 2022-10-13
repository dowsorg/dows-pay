package org.dows.pay.api.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.dows.pay.api.BizModel;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.PayResponse;
import org.dows.pay.api.annotation.ParamName;

import java.util.Map;

@Data
public abstract class AbstractPayRequest<T extends PayResponse> implements PayRequest<T> {

    @ApiModelProperty("租户或商户编号")
    @ParamName("tenantId")
    protected String tenantId;
    @ApiModelProperty("appId")
    @ParamName("appId")
    protected String appId;
    @ApiModelProperty("通道名")
    @ParamName("channel")
    protected String channel;
    @ApiModelProperty("业务方法")
    @ParamName("biz_method")
    protected String method;

//    @ApiModelProperty("json参数体")
//    @ParamName("biz_params")
//    protected Map<String, Object> params;

    @ApiModelProperty("业务json参数")
    @ParamName("biz_params")
    protected String bizContent;

    @ApiModelProperty("业务对象参数")
    @ParamName("biz_params")
    protected BizModel bizModel;

    protected Class<T> responseClass;

    public void autoSet(Map<String, Object> requestParams) {
        this.tenantId = (String) requestParams.get("tenantId");
        this.appId = (String) requestParams.get("appId");
        this.channel = (String) requestParams.get("channel");
    }

    @Override
    public PayRequest setTenantId(String tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    @Override
    public PayRequest setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    @Override
    public PayRequest setChannel(String channel) {
        this.channel = channel;
        return this;
    }

    @Override
    public PayRequest setMethod(String method) {
        this.method = method;
        return this;
    }

}
