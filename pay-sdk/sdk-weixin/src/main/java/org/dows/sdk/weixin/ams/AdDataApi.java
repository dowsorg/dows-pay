package org.dows.sdk.weixin.ams;

import org.dows.sdk.weixin.ams.request.GetAdposDetailRequest;
import org.dows.sdk.weixin.ams.request.GetAdposGenenralRequest;
import org.dows.sdk.weixin.ams.request.GetAgencyAdsDetailRequest;
import org.dows.sdk.weixin.ams.request.GetAgencyAdsStatRequest;
import org.dows.sdk.weixin.ams.response.GetAdposDetailResponse;
import org.dows.sdk.weixin.ams.response.GetAdposGenenralResponse;
import org.dows.sdk.weixin.ams.response.GetAgencyAdsDetailResponse;
import org.dows.sdk.weixin.ams.response.GetAgencyAdsStatResponse;

/**
 * @author lait.zhang@gmail.com
 * @Date 2023年5月28日 下午9:25:34
 * @description adDataApi
 */
public interface AdDataApi {

    /**
     * 该 API 用于获取小程序广告汇总数据。使用过程中如遇到问题，可在发帖交流。其中access_token为1、返回list中的记录按照date降序，slot_id升序排列，用户请以分页的形式获取。如果不传递广告位类型名称，将默认返回全部类型广告位的数据。2、请求参数中，page_size无上限，但建议服务商预估数据量级后分页获取
     * https://api.weixin.qq.com/wxa/operationams?action=agency_get_adpos_genenral&access_token=xxxxxxxxxxxxxxx
     *
     * @param GetAdposGenenralRequest
     */
    GetAdposGenenralResponse GetAdposGenenral(GetAdposGenenralRequest GetAdposGenenralRequest);

    /**
     * 该 API 用于获取小程序广告细分数据。使用过程中如遇到问题，可在发帖交流。其中access_token为1、返回list中的项按照date降序排列，用户请以分页的形式获取。当需要获取全部广告位的细分数据时，无需传递广告位类型名称及广告单元ID；当需要获取某类型广告位的细分数据时，仅需传递广告位类型名称；当需要获取某广告位 id 的细分数据时，仅需传递广告单元ID。2、请求参数中，page_size无上限，但建议服务商预估数据量级后分页获取
     * https://api.weixin.qq.com/wxa/operationams?action=agency_get_adunit_general&access_token=xxxxxxxxxxxxxxx
     *
     * @param GetAdposDetailRequest
     */
    GetAdposDetailResponse GetAdposDetail(GetAdposDetailRequest GetAdposDetailRequest);

    /**
     * 该 API 用于获取服务商通过流量主代运营模式产生的广告汇总数据。使用过程中如遇到问题，可在发帖交流。其中access_token为
     * https://api.weixin.qq.com/wxa/getdefaultamsinfo?action=get_agency_ads_stat&access_token=xxxxxxxxxxxxxxx
     *
     * @param GetAgencyAdsStatRequest
     */
    GetAgencyAdsStatResponse GetAgencyAdsStat(GetAgencyAdsStatRequest GetAgencyAdsStatRequest);

    /**
     * 该 API 用于获取授权服务商进行流量主代运营，分小程序产生的广告细分数据，最小颗粒度为广告单元id（aduint）。使用过程中如遇到问题，可在发帖交流。其中access_token为请注意： 返回list中的项按照date降序排列，用户请以分页的形式获取。当需要获取全部广告位的细分数据时，无需传递广告位类型名称；当需要获取某类型广告位的细分数据时，需传递广告位类型名称。
     * https://api.weixin.qq.com/wxa/getdefaultamsinfo?action=get_agency_ads_detail&access_token=xxxxxxxxxxxxxxx
     *
     * @param GetAgencyAdsDetailRequest
     */
    GetAgencyAdsDetailResponse GetAgencyAdsDetail(GetAgencyAdsDetailRequest GetAgencyAdsDetailRequest);
}