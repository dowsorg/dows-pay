package org.dows.sdk.weixin.officalaccount.management;

/**
 * @description linkMiniprogramApi
 * @author lait.zhang@gmail.com
 * @date  2023年5月28日 下午9:55:33
 */
public interface LinkMiniprogramApi{

    /**
     * 该接口用于获取公众号关联的小程序公众号需要先把“小程序管理”权限集授权给第三方平台，第三方平台才可以调用此接口进行关联和管理操作。
     * https://api.weixin.qq.com/cgi-bin/wxopen/wxamplinkget?access_token=ACCESS_TOKEN
     * 
     * @param getLinkMiniprogramRequest
     * 
     */
    GetLinkMiniprogramResponse getLinkMiniprogram(GetLinkMiniprogramRequest getLinkMiniprogramRequest);

    /**
     * 该接口用于关联小程序1、第三方平台调用接口发起关联2、公众号管理员收到模板消息，同意关联小程序。3、小程序管理员收到模板消息，同意关联公众号。4、关联成功
     * https://api.weixin.qq.com/cgi-bin/wxopen/wxamplink?access_token=ACCESS_TOKEN
     * 
     * @param linkMiniprogramRequest
     * 
     */
    LinkMiniprogramResponse linkMiniprogram(LinkMiniprogramRequest linkMiniprogramRequest);

    /**
     * 解除已关联的小程序
     * https://api.weixin.qq.com/cgi-bin/wxopen/wxampunlink?access_token=ACCESS_TOKEN
     * 
     * @param unlinkMiniprogramRequest
     * 
     */
    UnlinkMiniprogramResponse unlinkMiniprogram(UnlinkMiniprogramRequest unlinkMiniprogramRequest);
}