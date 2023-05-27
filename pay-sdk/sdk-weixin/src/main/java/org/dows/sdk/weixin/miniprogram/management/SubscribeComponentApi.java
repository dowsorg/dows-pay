package org.dows.sdk.weixin.miniprogram.management;

import org.dows.sdk.weixin.miniprogram.management.request.GetLinkForShowRequest;
import org.dows.sdk.weixin.miniprogram.management.request.GetShowItemRequest;
import org.dows.sdk.weixin.miniprogram.management.request.SetShowItemRequest;
import org.dows.sdk.weixin.miniprogram.management.response.GetLinkForShowResponse;
import org.dows.sdk.weixin.miniprogram.management.response.GetShowItemResponse;
import org.dows.sdk.weixin.miniprogram.management.response.SetShowItemResponse;

/**
 * @author
 * @description 调用方式以及出入参和HTTPS相同，仅是调用的token不同该接口所属的权限集id为：18服务商获得其中之一权限集授权后，可通过使用代商家进行调用
 * @date
 */
public interface SubscribeComponentApi {
    /**
     * 使用本接口可以所展示的公众号信息。使用过程中如遇到问题，可在发帖交流。
     *
     * @param getShowItemRequest
     */
    GetShowItemResponse getShowItem(GetShowItemRequest getShowItemRequest);

    /**
     * 通过本接口可以获取允许展示的公众号列表
     *
     * @param getLinkForShowRequest
     */
    GetLinkForShowResponse getLinkForShow(GetLinkForShowRequest getLinkForShowRequest);

    /**
     * 使用本接口可以设置所展示的公众号信息
     *
     * @param setShowItemRequest
     */
    SetShowItemResponse setShowItem(SetShowItemRequest setShowItemRequest);

}
