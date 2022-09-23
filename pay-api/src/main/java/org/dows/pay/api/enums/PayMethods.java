package org.dows.pay.api.enums;

import lombok.Getter;

public enum PayMethods {

    ISV_CREATE("dows.pay.isv.create", "", "isv服务商代商户创建小程序"),
    ISV_QUERY("dows.pay.isv.query", "", "isv查询代商家创建小程序记录"),
    ON_MERCHANT_CONFIRMED("dows.pay.merchant.confirmed", "", "商户确认服务商代创建小程序结果通知")




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
