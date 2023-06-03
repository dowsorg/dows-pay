package org.dows.sdk.weixin.bak.ams;

import org.dows.sdk.weixin.bak.ams.request.GetAdposDetailRequest;
import org.dows.sdk.weixin.bak.ams.request.GetAdposGenenralRequest;
import org.dows.sdk.weixin.bak.ams.request.GetAgencyAdsDetailRequest;
import org.dows.sdk.weixin.bak.ams.request.GetAgencyAdsStatRequest;
import org.dows.sdk.weixin.bak.ams.response.GetAdposDetailResponse;
import org.dows.sdk.weixin.bak.ams.response.GetAdposGenenralResponse;
import org.dows.sdk.weixin.bak.ams.response.GetAgencyAdsDetailResponse;
import org.dows.sdk.weixin.bak.ams.response.GetAgencyAdsStatResponse;

/**
 * @author lait.zhang@gmail.com
 * @description adDataApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface AdDataApi {

    /**
     * description: 该 API 用于获取小程序广告汇总数据。使用过程中如遇到问题，可在发帖交流。其中access_token为1、返回list中的记录按照date降序，slot_id升序排列，用户请以分页的形式获取。如果不传递广告位类型名称，将默认返回全部类型广告位的数据。2、请求参数中，page_size无上限，但建议服务商预估数据量级后分页获取
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-data/GetAdposGenenral.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=agency_get_adpos_genenral&access_token=ACCESS_TOKEN
     *
     * @param getAdposGenenralRequest
     */
    GetAdposGenenralResponse getAdposGenenral(GetAdposGenenralRequest getAdposGenenralRequest);

    /**
     * description: 该 API 用于获取小程序广告细分数据。使用过程中如遇到问题，可在发帖交流。其中access_token为1、返回list中的项按照date降序排列，用户请以分页的形式获取。当需要获取全部广告位的细分数据时，无需传递广告位类型名称及广告单元ID；当需要获取某类型广告位的细分数据时，仅需传递广告位类型名称；当需要获取某广告位 id 的细分数据时，仅需传递广告单元ID。2、请求参数中，page_size无上限，但建议服务商预估数据量级后分页获取
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-data/GetAdposDetail.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=agency_get_adunit_general&access_token=ACCESS_TOKEN
     *
     * @param getAdposDetailRequest
     */
    GetAdposDetailResponse getAdposDetail(GetAdposDetailRequest getAdposDetailRequest);

    /**
     * description: 该 API 用于获取服务商通过流量主代运营模式产生的广告汇总数据。使用过程中如遇到问题，可在发帖交流。其中access_token为
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-data/GetAgencyAdsStat.html
     * api: https://api.weixin.qq.com/wxa/getdefaultamsinfo?action=get_agency_ads_stat&access_token=ACCESS_TOKEN
     *
     * @param getAgencyAdsStatRequest
     */
    GetAgencyAdsStatResponse getAgencyAdsStat(GetAgencyAdsStatRequest getAgencyAdsStatRequest);

    /**
     * description: 该 API 用于获取授权服务商进行流量主代运营，分小程序产生的广告细分数据，最小颗粒度为广告单元id（aduint）。使用过程中如遇到问题，可在发帖交流。其中access_token为请注意： 返回list中的项按照date降序排列，用户请以分页的形式获取。当需要获取全部广告位的细分数据时，无需传递广告位类型名称；当需要获取某类型广告位的细分数据时，需传递广告位类型名称。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-data/GetAgencyAdsDetail.html
     * api: https://api.weixin.qq.com/wxa/getdefaultamsinfo?action=get_agency_ads_detail&access_token=ACCESS_TOKEN
     *
     * @param getAgencyAdsDetailRequest
     */
    GetAgencyAdsDetailResponse getAgencyAdsDetail(GetAgencyAdsDetailRequest getAgencyAdsDetailRequest);
}