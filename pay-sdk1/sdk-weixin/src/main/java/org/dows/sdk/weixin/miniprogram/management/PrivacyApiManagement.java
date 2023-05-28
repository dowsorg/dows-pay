package org.dows.sdk.weixin.miniprogram.management;

/**
 * 
 */
public interface privacyApiManagement{

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