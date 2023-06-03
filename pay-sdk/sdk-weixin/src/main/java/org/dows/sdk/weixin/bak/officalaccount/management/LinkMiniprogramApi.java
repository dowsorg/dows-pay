package org.dows.sdk.weixin.bak.officalaccount.management;

import org.dows.sdk.weixin.bak.officalaccount.management.request.GetLinkMiniprogramRequest;
import org.dows.sdk.weixin.bak.officalaccount.management.request.LinkMiniprogramRequest;
import org.dows.sdk.weixin.bak.officalaccount.management.request.UnlinkMiniprogramRequest;
import org.dows.sdk.weixin.bak.officalaccount.management.response.GetLinkMiniprogramResponse;
import org.dows.sdk.weixin.bak.officalaccount.management.response.LinkMiniprogramResponse;
import org.dows.sdk.weixin.bak.officalaccount.management.response.UnlinkMiniprogramResponse;

/**
 * @author lait.zhang@gmail.com
 * @description linkMiniprogramApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface LinkMiniprogramApi {

    /**
     * description: 该接口用于获取公众号关联的小程序公众号需要先把“小程序管理”权限集授权给第三方平台，第三方平台才可以调用此接口进行关联和管理操作。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/officalaccount-management/link-miniprogram/getLinkMiniprogram.html
     * api: https://api.weixin.qq.com/cgi-bin/wxopen/wxamplinkget?access_token=ACCESS_TOKEN
     *
     * @param getLinkMiniprogramRequest
     */
    GetLinkMiniprogramResponse getLinkMiniprogram(GetLinkMiniprogramRequest getLinkMiniprogramRequest);

    /**
     * description: 该接口用于关联小程序1、第三方平台调用接口发起关联2、公众号管理员收到模板消息，同意关联小程序。3、小程序管理员收到模板消息，同意关联公众号。4、关联成功
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/officalaccount-management/link-miniprogram/linkMiniprogram.html
     * api: https://api.weixin.qq.com/cgi-bin/wxopen/wxamplink?access_token=ACCESS_TOKEN
     *
     * @param linkMiniprogramRequest
     */
    LinkMiniprogramResponse linkMiniprogram(LinkMiniprogramRequest linkMiniprogramRequest);

    /**
     * description: 解除已关联的小程序
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/officalaccount-management/link-miniprogram/unlinkMiniprogram.html
     * api: https://api.weixin.qq.com/cgi-bin/wxopen/wxampunlink?access_token=ACCESS_TOKEN
     *
     * @param unlinkMiniprogramRequest
     */
    UnlinkMiniprogramResponse unlinkMiniprogram(UnlinkMiniprogramRequest unlinkMiniprogramRequest);
}