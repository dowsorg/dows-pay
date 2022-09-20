package org.dows.pay.api.enums;

import lombok.Getter;

public enum PayMethods {

    ISV_CREATE("dows.pay.isv.create", "", "代理商代商户开通ISV支付"),
    ISV_QUERY("dows.pay.isv.query", "", "代理商代商户查询ISV开通结果"),
    ON_ISV_MERCHANT_ACCREDIT("dows.pay.isv.merchant.accredit", "", "商户授权代理商通道发起的回调")




    ;

    @Getter
    private String namespace;

    @Getter
    private String argNames;
    @Getter
    private String descr;

    PayMethods(String namespace, String argNames, String descr) {
        this.namespace = namespace;
        this.argNames = argNames;
        this.descr = descr;
    }
}
