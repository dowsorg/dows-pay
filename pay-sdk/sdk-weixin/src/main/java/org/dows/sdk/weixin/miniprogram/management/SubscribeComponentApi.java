package org.dows.sdk.weixin.miniprogram.management;

import org.dows.sdk.weixin.miniprogram.management.request.GetLinkForShowRequest;
import org.dows.sdk.weixin.miniprogram.management.request.GetShowItemRequest;
import org.dows.sdk.weixin.miniprogram.management.request.SetShowItemRequest;
import org.dows.sdk.weixin.miniprogram.management.response.GetLinkForShowResponse;
import org.dows.sdk.weixin.miniprogram.management.response.GetShowItemResponse;
import org.dows.sdk.weixin.miniprogram.management.response.SetShowItemResponse;

/**
 * @author lait.zhang@gmail.com
 * @Date 2023年5月28日 下午9:25:34
 * @description subscribeComponentApi
 */
public interface SubscribeComponentApi {

    /**
     * 使用本接口可以所展示的公众号信息。使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/wxa/getshowwxaitem?access_token=ACCESS_TOKEN
     *
     * @param getShowItemRequest
     */
    GetShowItemResponse getShowItem(GetShowItemRequest getShowItemRequest);

    /**
     * 通过本接口可以获取允许展示的公众号列表
     * https://api.weixin.qq.com/wxa/getwxamplinkforshow?access_token=ACCESS_TOKEN
     *
     * @param getLinkForShowRequest
     */
    GetLinkForShowResponse getLinkForShow(GetLinkForShowRequest getLinkForShowRequest);

    /**
     * 使用本接口可以设置所展示的公众号信息
     * https://api.weixin.qq.com/wxa/updateshowwxaitem?access_token=ACCESS_TOKEN
     *
     * @param setShowItemRequest
     */
    SetShowItemResponse setShowItem(SetShowItemRequest setShowItemRequest);
}