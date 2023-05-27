package org.dows.sdk.weixin.ams;

import org.dows.sdk.weixin.ams.request.GetAmsCategoryBlackListRequest;
import org.dows.sdk.weixin.ams.request.GetBlackListRequest;
import org.dows.sdk.weixin.ams.request.SetAmsCategoryBlackListRequest;
import org.dows.sdk.weixin.ams.request.SetBlackListRequest;
import org.dows.sdk.weixin.ams.response.GetAmsCategoryBlackListResponse;
import org.dows.sdk.weixin.ams.response.GetBlackListResponse;
import org.dows.sdk.weixin.ams.response.SetAmsCategoryBlackListResponse;
import org.dows.sdk.weixin.ams.response.SetBlackListResponse;

/**
 * @author
 * @description
 * @date
 */
public interface AdBlackApi {
    /**
     * 该 API 用于查询当前小程序广告屏蔽的广告主。使用过程中如遇到问题，可在发帖交流。其中access_token为
     *
     * @param GetBlackListRequest
     */
    GetBlackListResponse GetBlackList(GetBlackListRequest GetBlackListRequest);

    /**
     * 该 API 用于设置小程序广告屏蔽的广告主。使用过程中如遇到问题，可在发帖交流。其中access_token为
     *
     * @param SetBlackListRequest
     */
    SetBlackListResponse SetBlackList(SetBlackListRequest SetBlackListRequest);

    /**
     * 该 API 用于查询小程序广告行业屏蔽信息。使用过程中如遇到问题，可在发帖交流。其中access_token为
     *
     * @param GetAmsCategoryBlackListRequest
     */
    GetAmsCategoryBlackListResponse GetAmsCategoryBlackList(GetAmsCategoryBlackListRequest GetAmsCategoryBlackListRequest);

    /**
     * 该 API 用于设置小程序广告行业屏蔽信息。使用过程中如遇到问题，可在发帖交流。其中access_token为
     *
     * @param SetAmsCategoryBlackListRequest
     */
    SetAmsCategoryBlackListResponse SetAmsCategoryBlackList(SetAmsCategoryBlackListRequest SetAmsCategoryBlackListRequest);


}
