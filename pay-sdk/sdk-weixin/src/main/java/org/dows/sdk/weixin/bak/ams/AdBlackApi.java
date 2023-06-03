package org.dows.sdk.weixin.bak.ams;

import org.dows.sdk.weixin.bak.ams.request.GetAmsCategoryBlackListRequest;
import org.dows.sdk.weixin.bak.ams.request.GetBlackListRequest;
import org.dows.sdk.weixin.bak.ams.request.SetAmsCategoryBlackListRequest;
import org.dows.sdk.weixin.bak.ams.request.SetBlackListRequest;
import org.dows.sdk.weixin.bak.ams.response.GetAmsCategoryBlackListResponse;
import org.dows.sdk.weixin.bak.ams.response.GetBlackListResponse;
import org.dows.sdk.weixin.bak.ams.response.SetAmsCategoryBlackListResponse;
import org.dows.sdk.weixin.bak.ams.response.SetBlackListResponse;

/**
 * @author lait.zhang@gmail.com
 * @description adBlackApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface AdBlackApi {

    /**
     * description: 该 API 用于查询当前小程序广告屏蔽的广告主。使用过程中如遇到问题，可在发帖交流。其中access_token为
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-black/GetBlackList.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=agency_get_black_list&access_token=ACCESS_TOKEN
     *
     * @param getBlackListRequest
     */
    GetBlackListResponse getBlackList(GetBlackListRequest getBlackListRequest);

    /**
     * description: 该 API 用于设置小程序广告屏蔽的广告主。使用过程中如遇到问题，可在发帖交流。其中access_token为
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-black/SetBlackList.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=agency_set_black_list&access_token=ACCESS_TOKEN
     *
     * @param setBlackListRequest
     */
    SetBlackListResponse setBlackList(SetBlackListRequest setBlackListRequest);

    /**
     * description: 该 API 用于查询小程序广告行业屏蔽信息。使用过程中如遇到问题，可在发帖交流。其中access_token为
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-black/GetAmsCategoryBlackList.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=agency_get_mp_amscategory_blacklist&access_token=ACCESS_TOKEN
     *
     * @param getAmsCategoryBlackListRequest
     */
    GetAmsCategoryBlackListResponse getAmsCategoryBlackList(GetAmsCategoryBlackListRequest getAmsCategoryBlackListRequest);

    /**
     * description: 该 API 用于设置小程序广告行业屏蔽信息。使用过程中如遇到问题，可在发帖交流。其中access_token为
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-black/SetAmsCategoryBlackList.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=agency_set_mp_amscategory_blacklist&access_token=ACCESS_TOKEN
     *
     * @param setAmsCategoryBlackListRequest
     */
    SetAmsCategoryBlackListResponse setAmsCategoryBlackList(SetAmsCategoryBlackListRequest setAmsCategoryBlackListRequest);
}