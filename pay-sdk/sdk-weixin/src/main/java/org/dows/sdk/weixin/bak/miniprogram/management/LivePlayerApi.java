package org.dows.sdk.weixin.bak.miniprogram.management;

import org.dows.sdk.weixin.bak.miniprogram.management.request.ApplyLivelnfoRequest;
import org.dows.sdk.weixin.bak.miniprogram.management.response.ApplyLivelnfoResponse;

/**
 * @author lait.zhang@gmail.com
 * @description livePlayerApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface LivePlayerApi {

    /**
     * description: 通过该接口，第三方开发者可帮助商家发起小程序直播功能的申请。使用过程中如遇到问题，可在发帖交流。1、服务商获取商家的小程序直播权限授权（权限集ID：52），授权流程参考。2、服务商调用接口【直播功能申请api】帮助商家发起小程序直播权限的申请。3、平台向小程序管理微信下发模板消息。管理员需在24 小时内点击消息，进行确认同意《微信小程序直播功能服务条款》；4、商家确认开通成功后，相关通知会通过消息与事件接收 URL 推送给服务商。5、开通了直播之后，服务商可以调用其他直播的接口进行直播管理，详情可查看“小程序文档中心-服务端-直播”的接口文档1、服务商调用接口后，小程序管理员将收到【公众平台安全助手】服务号推送的模板消息。2、24小时内点击消息卡片进入功能开通页面，阅读并同意《微信小程序直播功能服务条款》后，提交功能申请。超时未进行功能申请，则本次申请失效。3、申请提交后将实时反馈申请结果。开通结果会向消息与事件接收 URL 推送相关通知。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/live-player/applyLivelnfo.html
     * api: https://api.weixin.qq.com/wxa/business/applyliveinfo?access_token=ACCESS_TOKEN
     *
     * @param applyLivelnfoRequest
     */
    ApplyLivelnfoResponse applyLivelnfo(ApplyLivelnfoRequest applyLivelnfoRequest);
}