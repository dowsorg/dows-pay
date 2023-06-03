package org.dows.sdk.weixin.open.dsjglxcx;

import org.dows.sdk.weixin.open.dsjglxcx.request.ShenQingKaiTongWuLiuChaXunZuJianRequest;
import org.dows.sdk.weixin.open.dsjglxcx.request.ShenQingKaiTongWuLiuTuiHuoZuJianRequest;
import org.dows.sdk.weixin.open.dsjglxcx.request.ShenQingKaiTongWuLiuXiaoXiRequest;
import org.dows.sdk.weixin.open.dsjglxcx.response.ShenQingKaiTongWuLiuChaXunZuJianResponse;
import org.dows.sdk.weixin.open.dsjglxcx.response.ShenQingKaiTongWuLiuTuiHuoZuJianResponse;
import org.dows.sdk.weixin.open.dsjglxcx.response.ShenQingKaiTongWuLiuXiaoXiResponse;

/**
 * 微信物流服务
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface WeiXinWuLiuFuWuApi {

    /**
     * 申请开通物流消息
     * descr: 1.、服务商获取商家的【微信物流服务】权限授权（权限集ID：45），授权流程参考,。,2.、服务商调用接口【物流消息申请api】帮助商家发起物流消息功能权限的申请。,3、 平台向小程序管理微信下发模板消息。管理员需在24 小时内点击消息，进行确认同意《小程序物流功能服务条款》；,1.、服务商调用接口后，小程序管理员将收到【公众平台安全助手】服务号推送的模板消息。,2.、24小时内点击消息卡片进入功能开通页面，阅读并同意《小程序物流功能服务条款》后，提交功能申请。超时未进行功能申请，则本次申请失效。,3.、申请提交后将实时反馈申请结果。,4、开通物流消息功能后，服务商可代商家小程序调用物流消息服务其他接口，详情可查看"小程序文档中心-服务端-物流消息服务"的接口文档。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/logistics-service/applyMsgPlugin.html
     * api: https://api.weixin.qq.com/cgi-bin/express/delivery/open_msg/open_openmsg?access_token=ACCESS_TOKEN
     *
     * @param shenQingKaiTongWuLiuXiaoXiRequest
     */
    ShenQingKaiTongWuLiuXiaoXiResponse shenQingKaiTongWuLiuXiaoXi(ShenQingKaiTongWuLiuXiaoXiRequest shenQingKaiTongWuLiuXiaoXiRequest);

    /**
     * 申请开通物流退货组件
     * descr: 调用额度：500次/一天,1、服务商获取商家的【微信物流服务】权限授权（权限集ID：45），授权流程参考,。,2、服务商调用接口【退货组件申请api】帮助商家发起物流退货组件权限的申请。,3、平台向小程序管理微信下发模板消息。管理员需在24 小时内点击消息，进行确认同意《小程序物流功能服务条款》；,4、开通物流退货组件功能后，服务商可代商家小程序调用物流消息服务其他接口，详情可查看"小程序文档中心-服务端-物流消息服务"的接口文档。,1、服务商调用接口后，小程序管理员将收到【公众平台安全助手】服务号推送的模板消息。,2、24小时内点击消息卡片进入功能开通页面，阅读并同意《小程序物流功能服务条款》后，提交功能申请。超时未进行功能申请，则本次申请失效。,3、申请提交后将实时反馈申请结果。,### 服务商使用流程,1、当服务商调用时请使用,以调用物流退货组件业务接口。,2、请务必先完成授权后再调用（权限集ID：45），否则会出现61007的错误。,3、点击查看
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/logistics-service/applyReturnPlugin.html
     * api: https://api.weixin.qq.com/cgi-bin/express/delivery/return/open_return?access_token=ACCESS_TOKEN
     *
     * @param shenQingKaiTongWuLiuTuiHuoZuJianRequest
     */
    ShenQingKaiTongWuLiuTuiHuoZuJianResponse shenQingKaiTongWuLiuTuiHuoZuJian(ShenQingKaiTongWuLiuTuiHuoZuJianRequest shenQingKaiTongWuLiuTuiHuoZuJianRequest);

    /**
     * 申请开通物流查询组件
     * descr: 调用额度：500次/一天,1、服务商获取商家的【微信物流服务】权限授权（权限集ID：45），授权流程参考,。,2、服务商调用接口【查询组件申请api】帮助商家发起物流查询组件权限的申请。,3、平台向小程序管理微信下发模板消息。管理员需在24 小时内点击消息，进行确认同意《小程序物流功能服务条款》；,4、开通物流查询组件功能后，服务商可代商家小程序调用物流消息服务其他接口，详情可查看"小程序文档中心-服务端-物流消息服务"的接口文档。,1、服务商调用接口后，小程序管理员将收到【公众平台安全助手】服务号推送的模板消息。,2、 24小时内点击消息卡片进入功能开通页面，阅读并同意《小程序物流功能服务条款》后，提交功能申请。超时未进行功能申请，则本次申请失效。,3、申请提交后将实时反馈申请结果。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/logistics-service/applyQueryPlugin.html
     * api: https://api.weixin.qq.com/cgi-bin/express/delivery/open_msg/open_query_plugin?access_token=ACCESS_TOKEN
     *
     * @param shenQingKaiTongWuLiuChaXunZuJianRequest
     */
    ShenQingKaiTongWuLiuChaXunZuJianResponse shenQingKaiTongWuLiuChaXunZuJian(ShenQingKaiTongWuLiuChaXunZuJianRequest shenQingKaiTongWuLiuChaXunZuJianRequest);
}