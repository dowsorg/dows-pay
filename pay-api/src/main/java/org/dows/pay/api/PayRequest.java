package org.dows.pay.api;

import java.util.Map;

public interface PayRequest<T extends PayResponse> {


    /**
     * 获取租户号或商户号
     *
     * @return
     */
    String getTenantId();

    /**
     * 获取应用ID
     *
     * @return
     */
    String getAppId();

    /**
     * 获取支付通道
     *
     * @return
     */
    String getChannel();

    /**
     * 获取支付方法名
     *
     * @return
     */
    String getMethod();


    /**
     * 获取支付参数
     *
     * @return
     */
    Map<String,Object> getParams();


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
