package org.dows.sdk.weixin.bak.cloudbase.common;

import org.dows.sdk.weixin.bak.cloudbase.common.request.CheckMobileConfigRequest;
import org.dows.sdk.weixin.bak.cloudbase.common.request.CreateCloudUserRequest;
import org.dows.sdk.weixin.bak.cloudbase.common.request.GetCloudTokenRequest;
import org.dows.sdk.weixin.bak.cloudbase.common.request.SetCloudAccessTokenRequest;
import org.dows.sdk.weixin.bak.cloudbase.common.response.CheckMobileConfigResponse;
import org.dows.sdk.weixin.bak.cloudbase.common.response.CreateCloudUserResponse;
import org.dows.sdk.weixin.bak.cloudbase.common.response.GetCloudTokenResponse;
import org.dows.sdk.weixin.bak.cloudbase.common.response.SetCloudAccessTokenResponse;

/**
 * @author lait.zhang@gmail.com
 * @description adminManagementApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface AdminManagementApi {

    /**
     * description: 通过本接口可以开启或关闭cloudbase_access_token的使用权限，使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/admin-management/setCloudAccessToken.html
     * api: https://api.weixin.qq.com/tcb/usecloudaccesstoken?access_token=ACCESS_TOKEN
     *
     * @param setCloudAccessTokenRequest
     */
    SetCloudAccessTokenResponse setCloudAccessToken(SetCloudAccessTokenRequest setCloudAccessTokenRequest);

    /**
     * description: 通过本接口可以开通云开发。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/admin-management/createCloudUser.html
     * api: https://api.weixin.qq.com/tcb/createclouduser?access_token=ACCESS_TOKEN
     *
     * @param createCloudUserRequest
     */
    CreateCloudUserResponse createCloudUser(CreateCloudUserRequest createCloudUserRequest);

    /**
     * description: 1、该接口有频率限制: 10次每小时。2、腾讯云 API 调用说明
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/admin-management/getCloudToken.html
     * api: https://api.weixin.qq.com/tcb/getqcloudtoken?access_token=ACCESS_TOKEN
     *
     * @param getCloudTokenRequest
     */
    GetCloudTokenResponse getCloudToken(GetCloudTokenRequest getCloudTokenRequest);

    /**
     * description: 通过本接口可以查询小程序是否绑定了手机号，并支持推送模版消息给小程序管理员收集手机号。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/admin-management/checkMobileConfig.html
     * api: https://api.weixin.qq.com/tcb/checkmobile?access_token=ACCESS_TOKEN
     *
     * @param checkMobileConfigRequest
     */
    CheckMobileConfigResponse checkMobileConfig(CheckMobileConfigRequest checkMobileConfigRequest);
}