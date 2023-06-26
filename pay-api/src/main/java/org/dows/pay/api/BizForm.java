package org.dows.pay.api;

/**
 * 业务表单接口
 */
public interface BizForm {

    default String getAppId() {
        return null;
    }

    default String getTenantId() {
        return null;
    }

    default String getChannel() {
        return null;
    }

    default String getAuthorizerAccessToken() {
        return null;
    }

    default String getMerchantAppId() {
        return null;
    }

    default String getApplyOrderNo() {
        return null;
    }
}
