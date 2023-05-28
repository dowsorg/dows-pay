package org.dows.sdk.weixin.miniprogram.management;

/**
 * @description privacyApiManagementApi
 * @author lait.zhang@gmail.com
 * @date  2023年5月28日 下午9:55:33
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