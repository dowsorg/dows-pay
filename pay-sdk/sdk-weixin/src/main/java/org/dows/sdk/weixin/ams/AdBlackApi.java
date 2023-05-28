package org.dows.sdk.weixin.ams;

/**
 * @author lait.zhang@gmail.com
 * @description adBlackApi
 */
public interface AdBlackApi{

    /**
     * 该 API 用于查询当前小程序广告屏蔽的广告主。使用过程中如遇到问题，可在发帖交流。其中access_token为
     * https://api.weixin.qq.com/wxa/operationams?action=agency_get_black_list&access_token=xxxxxxxxxxxxxxx
     * 
     * @param GetBlackListRequest
     * 
     */
    GetBlackListResponse GetBlackList(GetBlackListRequest GetBlackListRequest);

    /**
     * 该 API 用于设置小程序广告屏蔽的广告主。使用过程中如遇到问题，可在发帖交流。其中access_token为
     * https://api.weixin.qq.com/wxa/operationams?action=agency_set_black_list&access_token=xxxxxxxxxxxxxxx
     * 
     * @param SetBlackListRequest
     * 
     */
    SetBlackListResponse SetBlackList(SetBlackListRequest SetBlackListRequest);

    /**
     * 该 API 用于查询小程序广告行业屏蔽信息。使用过程中如遇到问题，可在发帖交流。其中access_token为
     * https://api.weixin.qq.com/wxa/operationams?action=agency_get_mp_amscategory_blacklist&access_token=xxxxxxxxxxxxxxx
     * 
     * @param GetAmsCategoryBlackListRequest
     * 
     */
    GetAmsCategoryBlackListResponse GetAmsCategoryBlackList(GetAmsCategoryBlackListRequest GetAmsCategoryBlackListRequest);

    /**
     * 该 API 用于设置小程序广告行业屏蔽信息。使用过程中如遇到问题，可在发帖交流。其中access_token为
     * https://api.weixin.qq.com/wxa/operationams?action=agency_set_mp_amscategory_blacklist&access_token=xxxxxxxxxxxxxxx
     * 
     * @param SetAmsCategoryBlackListRequest
     * 
     */
    SetAmsCategoryBlackListResponse SetAmsCategoryBlackList(SetAmsCategoryBlackListRequest SetAmsCategoryBlackListRequest);
}