package org.dows.sdk.weixin.bak.miniprogram.management;

import org.dows.sdk.weixin.bak.miniprogram.management.request.GetLinkForShowRequest;
import org.dows.sdk.weixin.bak.miniprogram.management.request.GetShowItemRequest;
import org.dows.sdk.weixin.bak.miniprogram.management.request.SetShowItemRequest;
import org.dows.sdk.weixin.bak.miniprogram.management.response.GetLinkForShowResponse;
import org.dows.sdk.weixin.bak.miniprogram.management.response.GetShowItemResponse;
import org.dows.sdk.weixin.bak.miniprogram.management.response.SetShowItemResponse;

/**
 * @author lait.zhang@gmail.com
 * @description subscribeComponentApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface SubscribeComponentApi {

    /**
     * description: 使用本接口可以所展示的公众号信息。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/subscribe-component/getShowItem.html
     * api: https://api.weixin.qq.com/wxa/getshowwxaitem?access_token=ACCESS_TOKEN
     *
     * @param getShowItemRequest
     */
    GetShowItemResponse getShowItem(GetShowItemRequest getShowItemRequest);

    /**
     * description: 通过本接口可以获取允许展示的公众号列表
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/subscribe-component/getLinkForShow.html
     * api: https://api.weixin.qq.com/wxa/getwxamplinkforshow?access_token=ACCESS_TOKEN
     *
     * @param getLinkForShowRequest
     */
    GetLinkForShowResponse getLinkForShow(GetLinkForShowRequest getLinkForShowRequest);

    /**
     * description: 使用本接口可以设置所展示的公众号信息
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/subscribe-component/setShowItem.html
     * api: https://api.weixin.qq.com/wxa/updateshowwxaitem?access_token=ACCESS_TOKEN
     *
     * @param setShowItemRequest
     */
    SetShowItemResponse setShowItem(SetShowItemRequest setShowItemRequest);
}