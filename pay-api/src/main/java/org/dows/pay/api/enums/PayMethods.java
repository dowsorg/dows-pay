package org.dows.pay.api.enums;

import lombok.Getter;

public enum PayMethods {
    // isv 相关接口
    ISV_CREATE("dows.pay.isv.create", "", "isv服务商代商户创建小程序"),
    ISV_QUERY("dows.pay.isv.query", "", "isv查询代商家创建小程序记录"),
    ON_ISV_MERCHANT_CONFIRMED("dows.pay.merchant.confirmed", "", "商户确认服务商代创建小程序结果通知"),


    // agent 相关接口
    AGENT_CREATE("dows.pay.agent.create", "", "开启代商户签约、创建应用事务"),
    AGENT_FACETOFACE("dows.pay.agent.facetoface", "", "协助商家申请签约当面付产品"),
    AGENT_COMMON("dows.pay.agent.common", "", "代签约产品通用接口"),
    AGENT_CONFIRM("dows.pay.agent.confirm", "", "提交代商户签约、创建应用事务"),
    AGENT_QUERY("dows.pay.agent.query", "", "查询申请单状态"),

    // mini 相关接口
    MINI_UPLOAD("dows.pay.mini.upload", "", "小程序基于模板上传版本"),
    MINI_APPLY("dows.pay.mini.apply", "", "小程序提交审核"),
    MINI_CANCEL("dows.pay.mini.cancel", "", "小程序撤销审核"),
    MINI_ONLINE("dows.pay.mini.online", "", "小程序上架"),
    MINI_OFFLINE("dows.pay.mini.offline", "", "小程序下架"),
    MINI_CREATE("dows.pay.mini.create", "", "小程序生成体验版"),


    ON_MINI_AUDITED("dows.pay.mini.audited", "", "小程序审核通过通知"),
    ON_MINI_REJECTED("dows.pay.mini.rejected", "", "小程序审核驳回通知"),
    ON_MINI_PASSED("dows.pay.mini.passed", "", "小程序审核不可营销通知"),

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
