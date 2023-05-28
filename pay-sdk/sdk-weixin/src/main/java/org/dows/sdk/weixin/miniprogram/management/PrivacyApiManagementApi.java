package org.dows.sdk.weixin.miniprogram.management;

/**
 * @author lait.zhang@gmail.com
 * @description privacyApiManagementApi
 */
public interface PrivacyApiManagementApi{

    /**
     * 
     * https://api.weixin.qq.com/wxa/security/apply_privacy_interface?access_token=ACCESS_TOKEN
     * 
     * @param applyPrivacyInterfaceRequest
     * 
     */
    ApplyPrivacyInterfaceResponse applyPrivacyInterface(ApplyPrivacyInterfaceRequest applyPrivacyInterfaceRequest);

    /**
     * 
     * https://api.weixin.qq.com/wxa/security/get_privacy_interface?access_token=ACCESS_TOKEN
     * 
     * @param getPrivacyInterfaceRequest
     * 
     */
    GetPrivacyInterfaceResponse getPrivacyInterface(GetPrivacyInterfaceRequest getPrivacyInterfaceRequest);
}