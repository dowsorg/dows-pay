package org.dows.sdk.weixin.open.xcxllzdyy;

import org.dows.sdk.weixin.open.xcxllzdyy.request.HuoQuPingBiDeGuangGaoZhuRequest;
import org.dows.sdk.weixin.open.xcxllzdyy.request.HuoQuXingYePingBiXinXiRequest;
import org.dows.sdk.weixin.open.xcxllzdyy.request.SheZhiPingBiDeGuangGaoZhuRequest;
import org.dows.sdk.weixin.open.xcxllzdyy.request.SheZhiXingYePingBiXinXiRequest;
import org.dows.sdk.weixin.open.xcxllzdyy.response.HuoQuPingBiDeGuangGaoZhuResponse;
import org.dows.sdk.weixin.open.xcxllzdyy.response.HuoQuXingYePingBiXinXiResponse;
import org.dows.sdk.weixin.open.xcxllzdyy.response.SheZhiPingBiDeGuangGaoZhuResponse;
import org.dows.sdk.weixin.open.xcxllzdyy.response.SheZhiXingYePingBiXinXiResponse;

/**
 * 广告屏蔽
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface GuangGaoPingBiApi {

    /**
     * 获取屏蔽的广告主
     * descr: 该 API 用于查询当前小程序广告屏蔽的广告主。使用过程中如遇到问题，可在,发帖交流。,其中access_token为
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-black/GetBlackList.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=agency_get_black_list&access_token=xxxxxxxxxxxxxxx
     *
     * @param huoQuPingBiDeGuangGaoZhuRequest
     */
    HuoQuPingBiDeGuangGaoZhuResponse huoQuPingBiDeGuangGaoZhu(HuoQuPingBiDeGuangGaoZhuRequest huoQuPingBiDeGuangGaoZhuRequest);

    /**
     * 设置屏蔽的广告主
     * descr: 该 API 用于设置小程序广告屏蔽的广告主。使用过程中如遇到问题，可在,发帖交流。,其中access_token为
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-black/SetBlackList.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=agency_set_black_list&access_token=xxxxxxxxxxxxxxx
     *
     * @param sheZhiPingBiDeGuangGaoZhuRequest
     */
    SheZhiPingBiDeGuangGaoZhuResponse sheZhiPingBiDeGuangGaoZhu(SheZhiPingBiDeGuangGaoZhuRequest sheZhiPingBiDeGuangGaoZhuRequest);

    /**
     * 获取行业屏蔽信息
     * descr: 该 API 用于查询小程序广告行业屏蔽信息。使用过程中如遇到问题，可在,发帖交流。,其中access_token为
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-black/GetAmsCategoryBlackList.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=agency_get_mp_amscategory_blacklist&access_token=xxxxxxxxxxxxxxx
     *
     * @param huoQuXingYePingBiXinXiRequest
     */
    HuoQuXingYePingBiXinXiResponse huoQuXingYePingBiXinXi(HuoQuXingYePingBiXinXiRequest huoQuXingYePingBiXinXiRequest);

    /**
     * 设置行业屏蔽信息
     * descr: 该 API 用于设置小程序广告行业屏蔽信息。使用过程中如遇到问题，可在,发帖交流。,其中access_token为
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-black/SetAmsCategoryBlackList.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=agency_set_mp_amscategory_blacklist&access_token=xxxxxxxxxxxxxxx
     *
     * @param sheZhiXingYePingBiXinXiRequest
     */
    SheZhiXingYePingBiXinXiResponse sheZhiXingYePingBiXinXi(SheZhiXingYePingBiXinXiRequest sheZhiXingYePingBiXinXiRequest);
}