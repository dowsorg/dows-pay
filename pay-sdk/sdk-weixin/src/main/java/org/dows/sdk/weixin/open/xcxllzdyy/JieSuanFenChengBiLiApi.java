package org.dows.sdk.weixin.open.xcxllzdyy;

import org.dows.sdk.weixin.open.xcxllzdyy.request.ChaXunFenZhangBiLiRequest;
import org.dows.sdk.weixin.open.xcxllzdyy.request.ChaXunZiDingYiFenZhangBiLiRequest;
import org.dows.sdk.weixin.open.xcxllzdyy.request.SheZhiMoRenFenZhangBiLiRequest;
import org.dows.sdk.weixin.open.xcxllzdyy.request.SheZhiZiDingYiFenZhangBiLiRequest;
import org.dows.sdk.weixin.open.xcxllzdyy.response.ChaXunFenZhangBiLiResponse;
import org.dows.sdk.weixin.open.xcxllzdyy.response.ChaXunZiDingYiFenZhangBiLiResponse;
import org.dows.sdk.weixin.open.xcxllzdyy.response.SheZhiMoRenFenZhangBiLiResponse;
import org.dows.sdk.weixin.open.xcxllzdyy.response.SheZhiZiDingYiFenZhangBiLiResponse;

/**
 * 结算分成比例
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface JieSuanFenChengBiLiApi {

    /**
     * 设置默认分账比例
     * descr: 关于小程序流量主代运营的详细介绍以及使用步骤、常见问题等请查看,，本文为小程序流量主代运营功能的接口文档。,该 API 用于服务商设定与全部小程序广告收入分账的比例。使用过程中如遇到问题，可在,发帖交流。,1、其中access_token为,2、服务商通过接口设置/更改分账比例，不代表比例生效；需要由商家在权限集授权流程中进行确认，才视为实际生效。,3、具体授权发起流程可以参考链接：,4、商家实际生效的分账比例，可以通过,进行查询
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/percentage/SetShareRatio.html
     * api: https://api.weixin.qq.com/wxa/setdefaultamsinfo?action=set_share_ratio&access_token=xxxxxxxxxxxxxxx
     *
     * @param sheZhiMoRenFenZhangBiLiRequest
     */
    SheZhiMoRenFenZhangBiLiResponse sheZhiMoRenFenZhangBiLi(SheZhiMoRenFenZhangBiLiRequest sheZhiMoRenFenZhangBiLiRequest);

    /**
     * 查询分账比例
     * descr: 该 API 用于查询服务商与小程序广告收入分账的比例。使用过程中如遇到问题，可在,发帖交流。,其中access_token为,假设小程序（appid为wxf3dsfsfsdf478）与授权服务商（appid为wxf3dsfsfsdf13d）分账比例中，授权服务商收益占比40%。 此时服务商（appid为wxf3dsfsfsdf13d）的默认分账比例为50%。 //查询 { "appid" : "wxf3dsfsfsdf13d" } { "ret": 0, "err_msg":"", "share_ratio": 50 } //查询 { "appid" : "wxf3dsfsfsdf478" } { "ret": 0, "err_msg":"", "share_ratio": 40 }
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/percentage/GetShareRatio.html
     * api: https://api.weixin.qq.com/wxa/getdefaultamsinfo?action=get_share_ratio&access_token=xxxxxxxxxxxxxxx
     *
     * @param chaXunFenZhangBiLiRequest
     */
    ChaXunFenZhangBiLiResponse chaXunFenZhangBiLi(ChaXunFenZhangBiLiRequest chaXunFenZhangBiLiRequest);

    /**
     * 设置自定义分账比例
     * descr: 该 API 用于服务商针对单个小程序设置个性化的广告收入分账的比例。使用过程中如遇到问题，可在,发帖交流。,1、其中access_token为,2、服务商通过接口设置/更改分账比例，不代表比例生效；需要由商家在权限集授权流程中进行确认，才视为实际生效。,3、具体授权发起流程可以参考链接：,4、商家实际生效的分账比例，可以通过,进行查询
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/percentage/SetCustomShareRatio.html
     * api: https://api.weixin.qq.com/wxa/setdefaultamsinfo?action=agency_set_custom_share_ratio&access_token=xxxxxxxxxxxxxxx
     *
     * @param sheZhiZiDingYiFenZhangBiLiRequest
     */
    SheZhiZiDingYiFenZhangBiLiResponse sheZhiZiDingYiFenZhangBiLi(SheZhiZiDingYiFenZhangBiLiRequest sheZhiZiDingYiFenZhangBiLiRequest);

    /**
     * 查询自定义分账比例
     * descr: 该 API 用于查询服务商针对单个小程序设置的个性化广告收入分账比例。使用过程中如遇到问题，可在,发帖交流。,其中access_token为
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/percentage/GetCustomShareRatio.html
     * api: https://api.weixin.qq.com/wxa/getdefaultamsinfo?action=agency_get_custom_share_ratio&access_token=xxxxxxxxxxxxxxx
     *
     * @param chaXunZiDingYiFenZhangBiLiRequest
     */
    ChaXunZiDingYiFenZhangBiLiResponse chaXunZiDingYiFenZhangBiLi(ChaXunZiDingYiFenZhangBiLiRequest chaXunZiDingYiFenZhangBiLiRequest);
}