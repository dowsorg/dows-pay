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
 * @author lait.zhang@gmail.com
 * @description adBlackApi
 * @date 2023年5月28日 下午9:55:33
 */
public interface AdBlackApi {

    /**
     * 该 API 用于查询当前小程序广告屏蔽的广告主。使用过程中如遇到问题，可在发帖交流。其中access_token为
     * https://api.weixin.qq.com/wxa/operationams?action=agency_get_black_list&access_token=xxxxxxxxxxxxxxx
     *
     * @param getBlackListRequest
     */
    GetBlackListResponse getBlackList(GetBlackListRequest getBlackListRequest);

    /**
     * 该 API 用于设置小程序广告屏蔽的广告主。使用过程中如遇到问题，可在发帖交流。其中access_token为
     * https://api.weixin.qq.com/wxa/operationams?action=agency_set_black_list&access_token=xxxxxxxxxxxxxxx
     *
     * @param setBlackListRequest
     */
    SetBlackListResponse setBlackList(SetBlackListRequest setBlackListRequest);

    /**
     * 该 API 用于查询小程序广告行业屏蔽信息。使用过程中如遇到问题，可在发帖交流。其中access_token为
     * https://api.weixin.qq.com/wxa/operationams?action=agency_get_mp_amscategory_blacklist&access_token=xxxxxxxxxxxxxxx
     *
     * @param getAmsCategoryBlackListRequest
     */
    GetAmsCategoryBlackListResponse getAmsCategoryBlackList(GetAmsCategoryBlackListRequest getAmsCategoryBlackListRequest);

    /**
     * 该 API 用于设置小程序广告行业屏蔽信息。使用过程中如遇到问题，可在发帖交流。其中access_token为
     * https://api.weixin.qq.com/wxa/operationams?action=agency_set_mp_amscategory_blacklist&access_token=xxxxxxxxxxxxxxx
     *
     * @param setAmsCategoryBlackListRequest
     */
    SetAmsCategoryBlackListResponse setAmsCategoryBlackList(SetAmsCategoryBlackListRequest setAmsCategoryBlackListRequest);
}