package org.dows.sdk.weixin.cloudbase.common;

import org.dows.sdk.weixin.cloudbase.common.request.CheckMobileConfigRequest;
import org.dows.sdk.weixin.cloudbase.common.request.CreateCloudUserRequest;
import org.dows.sdk.weixin.cloudbase.common.request.GetCloudTokenRequest;
import org.dows.sdk.weixin.cloudbase.common.response.CheckMobileConfigResponse;
import org.dows.sdk.weixin.cloudbase.common.response.CreateCloudUserResponse;
import org.dows.sdk.weixin.cloudbase.common.response.GetCloudTokenResponse;

/**
 * @author
 * @description 调用方式以及出入参和HTTPS相同，仅是调用的token不同该接口所属的权限集id为：49、64服务商获得其中之一权限集授权后，可通过使用代商家进行调用
 * @date
 */
public interface AdminManagementApi {
    /**
     * 通过本接口可以开启或关闭cloudbase_access_token的使用权限，使用过程中如遇到问题，可在发帖交流。
     *
     * @param setCloudAccessTokenRequest
     */
    SetCloudAccessTokenResponse setCloudAccessToken(SetCloudAccessTokenRequest setCloudAccessTokenRequest);

    /**
     * 通过本接口可以开通云开发。使用过程中如遇到问题，可在发帖交流。
     *
     * @param createCloudUserRequest
     */
    CreateCloudUserResponse createCloudUser(CreateCloudUserRequest createCloudUserRequest);

    /**
     * 1、该接口有频率限制: 10次每小时。2、腾讯云 API 调用说明
     *
     * @param getCloudTokenRequest
     */
    GetCloudTokenResponse getCloudToken(GetCloudTokenRequest getCloudTokenRequest);

    /**
     * 通过本接口可以查询小程序是否绑定了手机号，并支持推送模版消息给小程序管理员收集手机号。使用过程中如遇到问题，可在发帖交流。
     *
     * @param checkMobileConfigRequest
     */
    CheckMobileConfigResponse checkMobileConfig(CheckMobileConfigRequest checkMobileConfigRequest);

}
