package org.dows.sdk.weixin.open.xcxllzdyy;

import org.dows.sdk.weixin.open.xcxllzdyy.request.HuoQuFuWuShangGuangGaoHuiZongShuJuRequest;
import org.dows.sdk.weixin.open.xcxllzdyy.request.HuoQuFuWuShangGuangGaoMingXiShuJuRequest;
import org.dows.sdk.weixin.open.xcxllzdyy.request.HuoQuXiaoChengXuGuangGaoHuiZongShuJuRequest;
import org.dows.sdk.weixin.open.xcxllzdyy.request.HuoQuXiaoChengXuGuangGaoXiFenShuJuRequest;
import org.dows.sdk.weixin.open.xcxllzdyy.response.HuoQuFuWuShangGuangGaoHuiZongShuJuResponse;
import org.dows.sdk.weixin.open.xcxllzdyy.response.HuoQuFuWuShangGuangGaoMingXiShuJuResponse;
import org.dows.sdk.weixin.open.xcxllzdyy.response.HuoQuXiaoChengXuGuangGaoHuiZongShuJuResponse;
import org.dows.sdk.weixin.open.xcxllzdyy.response.HuoQuXiaoChengXuGuangGaoXiFenShuJuResponse;

/**
 * 广告数据
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface GuangGaoShuJuApi {

    /**
     * 获取小程序广告汇总数据
     * descr: 该 API 用于获取小程序广告汇总数据。使用过程中如遇到问题，可在,发帖交流。,其中access_token为,1、返回list中的记录按照date降序，slot_id升序排列，用户请以分页的形式获取。如果不传递广告位类型名称，将默认返回全部类型广告位的数据。,2、请求参数中，page_size无上限，但建议服务商预估数据量级后分页获取
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-data/GetAdposGenenral.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=agency_get_adpos_genenral&access_token=xxxxxxxxxxxxxxx
     *
     * @param huoQuXiaoChengXuGuangGaoHuiZongShuJuRequest
     */
    HuoQuXiaoChengXuGuangGaoHuiZongShuJuResponse huoQuXiaoChengXuGuangGaoHuiZongShuJu(HuoQuXiaoChengXuGuangGaoHuiZongShuJuRequest huoQuXiaoChengXuGuangGaoHuiZongShuJuRequest);

    /**
     * 获取小程序广告细分数据
     * descr: 该 API 用于获取小程序广告细分数据。使用过程中如遇到问题，可在,发帖交流。,其中access_token为,1、返回list中的项按照date降序排列，用户请以分页的形式获取。当需要获取全部广告位的细分数据时，无需传递广告位类型名称及广告单元ID；当需要获取某类型广告位的细分数据时，仅需传递广告位类型名称；当需要获取某广告位 id 的细分数据时，仅需传递广告单元ID。,2、请求参数中，page_size无上限，但建议服务商预估数据量级后分页获取
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-data/GetAdposDetail.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=agency_get_adunit_general&access_token=xxxxxxxxxxxxxxx
     *
     * @param huoQuXiaoChengXuGuangGaoXiFenShuJuRequest
     */
    HuoQuXiaoChengXuGuangGaoXiFenShuJuResponse huoQuXiaoChengXuGuangGaoXiFenShuJu(HuoQuXiaoChengXuGuangGaoXiFenShuJuRequest huoQuXiaoChengXuGuangGaoXiFenShuJuRequest);

    /**
     * 获取服务商广告汇总数据
     * descr: 该 API 用于获取服务商通过流量主代运营模式产生的广告汇总数据。使用过程中如遇到问题，可在,发帖交流。,其中access_token为
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-data/GetAgencyAdsStat.html
     * api: https://api.weixin.qq.com/wxa/getdefaultamsinfo?action=get_agency_ads_stat&access_token=xxxxxxxxxxxxxxx
     *
     * @param huoQuFuWuShangGuangGaoHuiZongShuJuRequest
     */
    HuoQuFuWuShangGuangGaoHuiZongShuJuResponse huoQuFuWuShangGuangGaoHuiZongShuJu(HuoQuFuWuShangGuangGaoHuiZongShuJuRequest huoQuFuWuShangGuangGaoHuiZongShuJuRequest);

    /**
     * 获取服务商广告明细数据
     * descr: 该 API 用于获取授权服务商进行流量主代运营，分小程序产生的广告细分数据，最小颗粒度为广告单元id（aduint）。使用过程中如遇到问题，可在,发帖交流。,其中access_token为,请注意： 返回list中的项按照date降序排列，用户请以分页的形式获取。当需要获取全部广告位的细分数据时，无需传递广告位类型名称；当需要获取某类型广告位的细分数据时，需传递广告位类型名称。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-data/GetAgencyAdsDetail.html
     * api: https://api.weixin.qq.com/wxa/getdefaultamsinfo?action=get_agency_ads_detail&access_token=xxxxxxxxxxxxxxx
     *
     * @param huoQuFuWuShangGuangGaoMingXiShuJuRequest
     */
    HuoQuFuWuShangGuangGaoMingXiShuJuResponse huoQuFuWuShangGuangGaoMingXiShuJu(HuoQuFuWuShangGuangGaoMingXiShuJuRequest huoQuFuWuShangGuangGaoMingXiShuJuRequest);
}