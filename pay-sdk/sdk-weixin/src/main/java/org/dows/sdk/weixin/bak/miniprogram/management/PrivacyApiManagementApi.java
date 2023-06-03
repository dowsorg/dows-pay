package org.dows.sdk.weixin.bak.miniprogram.management;

import org.dows.sdk.weixin.bak.miniprogram.management.request.ApplyPrivacyInterfaceRequest;
import org.dows.sdk.weixin.bak.miniprogram.management.request.GetPrivacyInterfaceRequest;
import org.dows.sdk.weixin.bak.miniprogram.management.response.ApplyPrivacyInterfaceResponse;
import org.dows.sdk.weixin.bak.miniprogram.management.response.GetPrivacyInterfaceResponse;

/**
 * @author lait.zhang@gmail.com
 * @description privacyApiManagementApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface PrivacyApiManagementApi {

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/privacy-api-management/applyPrivacyInterface.html
     * api: https://api.weixin.qq.com/wxa/security/apply_privacy_interface?access_token=ACCESS_TOKEN
     *
     * @param applyPrivacyInterfaceRequest
     */
    ApplyPrivacyInterfaceResponse applyPrivacyInterface(ApplyPrivacyInterfaceRequest applyPrivacyInterfaceRequest);

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/privacy-api-management/getPrivacyInterface.html
     * api: https://api.weixin.qq.com/wxa/security/get_privacy_interface?access_token=ACCESS_TOKEN
     *
     * @param getPrivacyInterfaceRequest
     */
    GetPrivacyInterfaceResponse getPrivacyInterface(GetPrivacyInterfaceRequest getPrivacyInterfaceRequest);
}