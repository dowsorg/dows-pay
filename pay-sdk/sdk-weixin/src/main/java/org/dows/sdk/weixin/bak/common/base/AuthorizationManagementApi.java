package org.dows.sdk.weixin.bak.common.base;

import org.dows.sdk.weixin.bak.common.base.request.GetAuthorizerInfoRequest;
import org.dows.sdk.weixin.bak.common.base.request.GetAuthorizerListRequest;
import org.dows.sdk.weixin.bak.common.base.request.GetAuthorizerOptionInfoRequest;
import org.dows.sdk.weixin.bak.common.base.request.SetAuthorizerOptionInfoRequest;
import org.dows.sdk.weixin.bak.common.base.response.GetAuthorizerInfoResponse;
import org.dows.sdk.weixin.bak.common.base.response.GetAuthorizerListResponse;
import org.dows.sdk.weixin.bak.common.base.response.GetAuthorizerOptionInfoResponse;
import org.dows.sdk.weixin.bak.common.base.response.SetAuthorizerOptionInfoResponse;

/**
 * @author lait.zhang@gmail.com
 * @description authorizationManagementApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface AuthorizationManagementApi {

    /**
     * description: 使用本 API 拉取当前所有已授权的帐号基本信息。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/authorization-management/getAuthorizerList.html
     * api: https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_list?access_token=ACCESS_TOKEN
     *
     * @param getAuthorizerListRequest
     */
    GetAuthorizerListResponse getAuthorizerList(GetAuthorizerListRequest getAuthorizerListRequest);

    /**
     * description: 该 API 用于获取授权方的基本信息，包括头像、昵称、帐号类型、认证类型、原始ID等信息。使用过程中如遇到问题，可在发帖交流注意： 公众号和小程序的接口返回结果不一样。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/authorization-management/getAuthorizerInfo.html
     * api: https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_info?access_token=ACCESS_TOKEN
     *
     * @param getAuthorizerInfoRequest
     */
    GetAuthorizerInfoResponse getAuthorizerInfo(GetAuthorizerInfoRequest getAuthorizerInfoRequest);

    /**
     * description: 本 API 用于设置授权方的公众号/小程序的选项信息，如：地理位置上报，语音识别开关，多客服开关。使用过程中如遇到问题，可在发帖交流注意： 设置各项选项设置信息，需要有授权方的授权，详见权限集说明。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/authorization-management/setAuthorizerOptionInfo.html
     * api: https://api.weixin.qq.com/cgi-bin/component/set_authorizer_option?access_token=ACCESS_TOKEN
     *
     * @param setAuthorizerOptionInfoRequest
     */
    SetAuthorizerOptionInfoResponse setAuthorizerOptionInfo(SetAuthorizerOptionInfoRequest setAuthorizerOptionInfoRequest);

    /**
     * description: 本 API 用于获取授权方的公众号/小程序的选项设置信息，如：地理位置上报，语音识别开关，多客服开关。使用过程中如遇到问题，可在发帖交流
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/authorization-management/getAuthorizerOptionInfo.html
     * api: https://api.weixin.qq.com/cgi-bin/component/get_authorizer_option?access_token=ACCESS_TOKEN
     *
     * @param getAuthorizerOptionInfoRequest
     */
    GetAuthorizerOptionInfoResponse getAuthorizerOptionInfo(GetAuthorizerOptionInfoRequest getAuthorizerOptionInfoRequest);
}