package org.dows.sdk.weixin.miniprogram.management;

import org.dows.sdk.weixin.miniprogram.management.request.ApplyPrivacyInterfaceRequest;
import org.dows.sdk.weixin.miniprogram.management.request.GetPrivacyInterfaceRequest;
import org.dows.sdk.weixin.miniprogram.management.response.ApplyPrivacyInterfaceResponse;
import org.dows.sdk.weixin.miniprogram.management.response.GetPrivacyInterfaceResponse;

/**
 * @author lait.zhang@gmail.com
 * @description privacyApiManagementApi
 * @date 2023年5月28日 下午9:55:33
 */
public interface PrivacyApiManagementApi {

    /**
     * https://api.weixin.qq.com/wxa/security/apply_privacy_interface?access_token=ACCESS_TOKEN
     *
     * @param applyPrivacyInterfaceRequest
     */
    ApplyPrivacyInterfaceResponse applyPrivacyInterface(ApplyPrivacyInterfaceRequest applyPrivacyInterfaceRequest);

    /**
     * https://api.weixin.qq.com/wxa/security/get_privacy_interface?access_token=ACCESS_TOKEN
     *
     * @param getPrivacyInterfaceRequest
     */
    GetPrivacyInterfaceResponse getPrivacyInterface(GetPrivacyInterfaceRequest getPrivacyInterfaceRequest);
}