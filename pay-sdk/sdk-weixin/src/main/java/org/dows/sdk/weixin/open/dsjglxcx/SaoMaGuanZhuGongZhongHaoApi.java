package org.dows.sdk.weixin.open.dsjglxcx;

import org.dows.sdk.weixin.open.dsjglxcx.request.HuoQuKeSheZhiGongZhongHaoLieBiaoRequest;
import org.dows.sdk.weixin.open.dsjglxcx.request.HuoQuYiSheZhiGongZhongHaoXinXiRequest;
import org.dows.sdk.weixin.open.dsjglxcx.request.SheZhiSaoMaGuanZhuDeGongZhongHaoRequest;
import org.dows.sdk.weixin.open.dsjglxcx.response.HuoQuKeSheZhiGongZhongHaoLieBiaoResponse;
import org.dows.sdk.weixin.open.dsjglxcx.response.HuoQuYiSheZhiGongZhongHaoXinXiResponse;
import org.dows.sdk.weixin.open.dsjglxcx.response.SheZhiSaoMaGuanZhuDeGongZhongHaoResponse;

/**
 * 扫码关注公众号
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface SaoMaGuanZhuGongZhongHaoApi {

    /**
     * 获取已设置公众号信息
     * descr: 使用本接口可以,所展示的公众号信息。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/subscribe-component/getShowItem.html
     * api: https://api.weixin.qq.com/wxa/getshowwxaitem?access_token=ACCESS_TOKEN
     *
     * @param huoQuYiSheZhiGongZhongHaoXinXiRequest
     */
    HuoQuYiSheZhiGongZhongHaoXinXiResponse huoQuYiSheZhiGongZhongHaoXinXi(HuoQuYiSheZhiGongZhongHaoXinXiRequest huoQuYiSheZhiGongZhongHaoXinXiRequest);

    /**
     * 获取可设置公众号列表
     * descr: 通过本接口可以获取,允许展示的公众号列表
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/subscribe-component/getLinkForShow.html
     * api: https://api.weixin.qq.com/wxa/getwxamplinkforshow?access_token=ACCESS_TOKEN
     *
     * @param huoQuKeSheZhiGongZhongHaoLieBiaoRequest
     */
    HuoQuKeSheZhiGongZhongHaoLieBiaoResponse huoQuKeSheZhiGongZhongHaoLieBiao(HuoQuKeSheZhiGongZhongHaoLieBiaoRequest huoQuKeSheZhiGongZhongHaoLieBiaoRequest);

    /**
     * 设置扫码关注的公众号
     * descr: 使用本接口可以设置,所展示的公众号信息
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/subscribe-component/setShowItem.html
     * api: https://api.weixin.qq.com/wxa/updateshowwxaitem?access_token=ACCESS_TOKEN
     *
     * @param sheZhiSaoMaGuanZhuDeGongZhongHaoRequest
     */
    SheZhiSaoMaGuanZhuDeGongZhongHaoResponse sheZhiSaoMaGuanZhuDeGongZhongHao(SheZhiSaoMaGuanZhuDeGongZhongHaoRequest sheZhiSaoMaGuanZhuDeGongZhongHaoRequest);
}