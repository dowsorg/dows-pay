package org.dows.sdk.weixin.cloudbase.common;

import org.dows.sdk.weixin.cloudbase.common.request.GetWechatPayAuthRequest;
import org.dows.sdk.weixin.cloudbase.common.request.GetWechatPayListRequest;
import org.dows.sdk.weixin.cloudbase.common.response.GetWechatPayAuthResponse;
import org.dows.sdk.weixin.cloudbase.common.response.GetWechatPayListResponse;

/**
 * @author
 * @description 调用方式以及出入参和HTTPS相同，仅是调用的token不同该接口所属的权限集id为：49、64、102服务商获得其中之一权限集授权后，可通过使用代商家进行调用
 * @date
 */
public interface WechatpayApi {
    /**
     * 通过本接口可以查询授权绑定的商户号列表，使用过程中如遇到问题，可在发帖交流。说明：小程序需授权【云开发权限集】或【云开发微信支付权限集】给第三方，第三方才可以代小程序调用此接口。
     *
     * @param getWechatPayListRequest
     */
    GetWechatPayListResponse getWechatPayList(GetWechatPayListRequest getWechatPayListRequest);

    /**
     * 通过本接口可以申请商户号授权，使用过程中如遇到问题，可在发帖交流。1）帐号绑定：商户号的超级管理员需要在微信支付提供的【微信支付商家助手】小程序上确认授权。2）jsapi 和 api 退款权限，需要前往微信支付商户平台我的授权产品中进行确认授权。
     *
     * @param getWechatPayAuthRequest
     */
    GetWechatPayAuthResponse getWechatPayAuth(GetWechatPayAuthRequest getWechatPayAuthRequest);

}
