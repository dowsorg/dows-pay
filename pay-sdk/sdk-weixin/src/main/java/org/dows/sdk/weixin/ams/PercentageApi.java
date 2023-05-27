package org.dows.sdk.weixin.ams;

import org.dows.sdk.weixin.ams.request.GetCustomShareRatioRequest;
import org.dows.sdk.weixin.ams.request.GetShareRatioRequest;
import org.dows.sdk.weixin.ams.request.SetCustomShareRatioRequest;
import org.dows.sdk.weixin.ams.request.SetShareRatioRequest;
import org.dows.sdk.weixin.ams.response.GetCustomShareRatioResponse;
import org.dows.sdk.weixin.ams.response.GetShareRatioResponse;
import org.dows.sdk.weixin.ams.response.SetCustomShareRatioResponse;
import org.dows.sdk.weixin.ams.response.SetShareRatioResponse;

/**
 * @author
 * @description
 * @date
 */
public interface PercentageApi {
    /**
     * 关于小程序流量主代运营的详细介绍以及使用步骤、常见问题等请查看，本文为小程序流量主代运营功能的接口文档。该 API 用于服务商设定与全部小程序广告收入分账的比例。使用过程中如遇到问题，可在发帖交流。1、其中access_token为2、服务商通过接口设置/更改分账比例，不代表比例生效；需要由商家在权限集授权流程中进行确认，才视为实际生效。3、具体授权发起流程可以参考链接：4、商家实际生效的分账比例，可以通过进行查询
     *
     * @param setShareRatioRequest
     */
    SetShareRatioResponse setShareRatio(SetShareRatioRequest setShareRatioRequest);

    /**
     * 该 API 用于查询服务商与小程序广告收入分账的比例。使用过程中如遇到问题，可在发帖交流。其中access_token为假设小程序（appid为wxf3dsfsfsdf478）与授权服务商（appid为wxf3dsfsfsdf13d）分账比例中，授权服务商收益占比40%。 此时服务商（appid为wxf3dsfsfsdf13d）的默认分账比例为50%。 //查询 { 'appid' : 'wxf3dsfsfsdf13d' } { 'ret': 0, 'err_msg':'', 'share_ratio': 50 } //查询 { 'appid' : 'wxf3dsfsfsdf478' } { 'ret': 0, 'err_msg':'', 'share_ratio': 40 }
     *
     * @param getShareRatioRequest
     */
    GetShareRatioResponse getShareRatio(GetShareRatioRequest getShareRatioRequest);

    /**
     * 该 API 用于服务商针对单个小程序设置个性化的广告收入分账的比例。使用过程中如遇到问题，可在发帖交流。1、其中access_token为2、服务商通过接口设置/更改分账比例，不代表比例生效；需要由商家在权限集授权流程中进行确认，才视为实际生效。3、具体授权发起流程可以参考链接：4、商家实际生效的分账比例，可以通过进行查询
     *
     * @param setCustomShareRatioRequest
     */
    SetCustomShareRatioResponse setCustomShareRatio(SetCustomShareRatioRequest setCustomShareRatioRequest);

    /**
     * 该 API 用于查询服务商针对单个小程序设置的个性化广告收入分账比例。使用过程中如遇到问题，可在发帖交流。其中access_token为
     *
     * @param getCustomShareRatioRequest
     */
    GetCustomShareRatioResponse getCustomShareRatio(GetCustomShareRatioRequest getCustomShareRatioRequest);

}
