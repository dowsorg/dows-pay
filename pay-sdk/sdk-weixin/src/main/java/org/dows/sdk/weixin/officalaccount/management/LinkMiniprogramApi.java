package org.dows.sdk.weixin.officalaccount.management;

import org.dows.sdk.weixin.officalaccount.management.request.GetLinkMiniprogramRequest;
import org.dows.sdk.weixin.officalaccount.management.request.LinkMiniprogramRequest;
import org.dows.sdk.weixin.officalaccount.management.request.UnlinkMiniprogramRequest;
import org.dows.sdk.weixin.officalaccount.management.response.GetLinkMiniprogramResponse;
import org.dows.sdk.weixin.officalaccount.management.response.LinkMiniprogramResponse;
import org.dows.sdk.weixin.officalaccount.management.response.UnlinkMiniprogramResponse;

/**
 * @author
 * @description 调用方式以及出入参和HTTPS相同，仅是调用的token不同该接口所属的权限集id为：33服务商获得其中之一权限集授权后，可通过使用代商家进行调用
 * @date
 */
public interface LinkMiniprogramApi {
    /**
     * 该接口用于获取公众号关联的小程序公众号需要先把“小程序管理”权限集授权给第三方平台，第三方平台才可以调用此接口进行关联和管理操作。
     *
     * @param getLinkMiniprogramRequest
     */
    GetLinkMiniprogramResponse getLinkMiniprogram(GetLinkMiniprogramRequest getLinkMiniprogramRequest);

    /**
     * 该接口用于关联小程序1、第三方平台调用接口发起关联2、公众号管理员收到模板消息，同意关联小程序。3、小程序管理员收到模板消息，同意关联公众号。4、关联成功
     *
     * @param linkMiniprogramRequest
     */
    LinkMiniprogramResponse linkMiniprogram(LinkMiniprogramRequest linkMiniprogramRequest);

    /**
     * 解除已关联的小程序
     *
     * @param unlinkMiniprogramRequest
     */
    UnlinkMiniprogramResponse unlinkMiniprogram(UnlinkMiniprogramRequest unlinkMiniprogramRequest);


}
