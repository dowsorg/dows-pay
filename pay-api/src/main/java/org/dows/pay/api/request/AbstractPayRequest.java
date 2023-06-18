package org.dows.pay.api.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dows.pay.api.BizForm;
import org.dows.pay.api.ChannelBizModel;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.PayResponse;
import org.dows.pay.api.annotation.ParamName;

@NoArgsConstructor
@Data
public abstract class AbstractPayRequest<T extends PayResponse> implements PayRequest<T> {

    @ApiModelProperty("租户或商户编号")
    @ParamName("tenantId")
    protected String tenantId;
    @ApiModelProperty("appId")
    @ParamName("appId")
    protected String appId;
    @ApiModelProperty("subOpenid")
    @ParamName("subOpenid")
    protected String subOpenid;
    @ApiModelProperty("通道名")
    @ParamName("channel")
    protected String channel;
    @ApiModelProperty("业务方法")
    @ParamName("biz_method")
    protected String method;

    @ApiModelProperty("业务json参数")
    @ParamName("biz_params")
    protected String bizContent;

    @ApiModelProperty("业务对象参数")
    @ParamName("biz_params")
    protected ChannelBizModel bizModel;

    protected Class<T> responseClass;

    @ApiModelProperty("接口调用凭证，该参数为 URL 参数，非 Body 参数。使用authorizer_access_token")
    @ParamName("authorizerAccessToken")
    private String authorizerAccessToken;
    @ApiModelProperty("商家应用ID")
    @ParamName("merchantAppId")
    private String merchantAppId;
    /**
     * 业务通用字段填充
     *
     * @param bizForm
     */
    public void autoSet(BizForm bizForm) {
        this.tenantId = bizForm.getTenantId();
        this.appId = bizForm.getAppId();
        this.channel = bizForm.getChannel();
        this.authorizerAccessToken = bizForm.getAuthorizerAccessToken();
        this.merchantAppId = bizForm.getMerchantAppId();
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
    public PayRequest setAuthorizerAccessToken(String authorizerAccessToken) {
        this.authorizerAccessToken = authorizerAccessToken;
        return this;
    }

    @Override
    public PayRequest setMerchantAppId(String merchantAppId) {
        this.merchantAppId = merchantAppId;
        return this;
    }


    @Override
    public PayRequest setSubOpenid(String subOpenid) {
        this.subOpenid = subOpenid;
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

    public PayRequest setBizModel(ChannelBizModel channelBizModel) {
        this.bizModel = channelBizModel;
        return this;
    }

}
