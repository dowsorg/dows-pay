package org.dows.pay.api;

public interface PayRequest<T extends PayResponse> {

    /**
     * 获取支付方法名
     *
     * @return
     */
    String getMehtod();

    /**
     * 获取支付通道
     *
     * @return
     */
    String getChannel();


    /**
     * 获取支付参数
     *
     * @return
     */
    String getParams();



    Class<T> getResponseClass();


    /**
     * 获取支付命名空间
     *
     * @return
     */
    default String getPayNamespace() {
        return getChannel() + "." + getMehtod();
    }


}
