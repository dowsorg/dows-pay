package org.dows.sdk.weixin.miniprogram.management;

import org.dows.sdk.weixin.miniprogram.management.request.ApplyPrivacyInterfaceRequest;
import org.dows.sdk.weixin.miniprogram.management.request.GetPrivacyInterfaceRequest;
import org.dows.sdk.weixin.miniprogram.management.response.ApplyPrivacyInterfaceResponse;
import org.dows.sdk.weixin.miniprogram.management.response.GetPrivacyInterfaceResponse;

/**
 * @author
 * @description 调用方式以及出入参和HTTPS相同，仅是调用的token不同该接口所属的权限集id为：18服务商获得其中之一权限集授权后，可通过使用代商家进行调用
 * @date
 */
public interface PrivacyApiManagementApi {
    /**
     * @param applyPrivacyInterfaceRequest
     */
    ApplyPrivacyInterfaceResponse applyPrivacyInterface(ApplyPrivacyInterfaceRequest applyPrivacyInterfaceRequest);

    /**
     * @param getPrivacyInterfaceRequest
     */
    GetPrivacyInterfaceResponse getPrivacyInterface(GetPrivacyInterfaceRequest getPrivacyInterfaceRequest);


}
