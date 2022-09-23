package org.dows.pay.api.enums;

import lombok.Getter;

public enum PayMethods {
    // isv 相关接口
    ISV_CREATE("dows.pay.isv.create", "", "isv服务商代商户创建小程序"),
    ISV_QUERY("dows.pay.isv.query", "", "isv查询代商家创建小程序记录"),
    ON_ISV_MERCHANT_CONFIRMED("dows.pay.merchant.confirmed", "", "商户确认服务商代创建小程序结果通知"),

    // mini 相关接口
    MINI_UPLOAD("dows.pay.mini.upload", "", "小程序基于模板上传版本"),
    MINI_APPLY("dows.pay.mini.apply", "", "小程序提交审核"),

    ON_MINI_AUDITED("dows.pay.mini.audited", "", "小程序审核通过通知"),
    ON_MINI_REJECTED("dows.pay.mini.rejected", "", "小程序审核驳回通知"),
    ON_MINI_PASSED("dows.pay.mini.passed", "", "小程序审核不可营销通知"),

    MINI_ONLINE("dows.pay.mini.online", "", "小程序上架"),
    MINI_ROLLBACK("dows.pay.mini.rollback", "", "小程序上架"),

    // mini 体验版
    MINI_EXPERIENCE_CREATE("dows.pay.mini.experience.create", "", "小程序生成体验版"),


    // 客服
    MINI_SERVICE_CONFIG("dows.pay.mini.service.config", "", "小程序设置客服方式"),

    // mini 二维码相关
    MINI_QR_BIND("dows.pay.mini.qrcode.bind", "", "关联普通二维码"),
    MINI_QR_UNBIND("dows.pay.mini.qrcode.unbind", "", "删除已关联普通二维码"),


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
