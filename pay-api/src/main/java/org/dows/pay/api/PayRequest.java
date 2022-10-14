package org.dows.pay.api;

public interface PayRequest<T extends PayResponse> {


    /**
     * 获取租户号或商户号
     *
     * @return
     */
    PayRequest setTenantId(String tenantId);

    String getTenantId();


    /**
     * 获取应用ID
     *
     * @return
     */
    PayRequest setAppId(String appId);

    String getAppId();

    /**
     * 获取支付通道code
     *
     * @return
     */
    PayRequest setChannel(String channel);

    String getChannel();

    /**
     * 获取支付方法名
     *
     * @return
     */
    PayRequest setMethod(String method);

    String getMethod();


    /**
     * 获取支付参数
     *
     * @return
     */
    PayRequest setBizModel(ChannelBizModel channelBizModel);

    ChannelBizModel getBizModel();


    Class<T> getResponseClass();


    /**
     * 获取支付命名空间
     *
     * @return
     */
    default String getPayNamespace() {
        return getMethod() + "." + getChannel();
    }
}
