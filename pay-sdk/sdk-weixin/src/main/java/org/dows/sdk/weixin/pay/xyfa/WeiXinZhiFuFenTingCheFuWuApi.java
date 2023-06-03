package org.dows.sdk.weixin.pay.xyfa;

import org.dows.sdk.weixin.pay.xyfa.request.*;
import org.dows.sdk.weixin.pay.xyfa.response.*;

/**
 * 微信支付分停车服务
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:52
 */
public interface WeiXinZhiFuFenTingCheFuWuApi {

    /**
     * 查询车牌服务开通信息
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_8_1.shtml
     * api: https://api.mch.weixin.qq.com/v3/vehicle/parking/services/find
     *
     * @param chaXunChePaiFuWuKaiTongXinXiRequest
     */
    ChaXunChePaiFuWuKaiTongXinXiResponse chaXunChePaiFuWuKaiTongXinXi(ChaXunChePaiFuWuKaiTongXinXiRequest chaXunChePaiFuWuKaiTongXinXiRequest);

    /**
     * 创建停车入场
     * descr: 创建停车入场API,最新更新时间：2021.08.06,车辆入场以后，商户调用该接口，创建停车入场信息。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_8_2.shtml
     * api: https://api.mch.weixin.qq.com/v3/vehicle/parking/parkings
     *
     * @param chuangJianTingCheRuChangRequest
     */
    ChuangJianTingCheRuChangResponse chuangJianTingCheRuChang(ChuangJianTingCheRuChangRequest chuangJianTingCheRuChangRequest);

    /**
     * 扣费受理
     * descr: 扣费受理API,最新更新时间：2021.08.06,商户请求扣费受理接口，会完成订单受理。微信支付进行异步扣款，支付完成后，会将订单支付结果发送给商户。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_8_3.shtml
     * api: https://api.mch.weixin.qq.com/v3/vehicle/transactions/parking
     *
     * @param kouFeiShouLiRequest
     */
    KouFeiShouLiResponse kouFeiShouLi(KouFeiShouLiRequest kouFeiShouLiRequest);

    /**
     * 查询订单
     * descr: 查询订单API,最新更新时间：2021.08.06,商户通过商户订单号，来查询订单信息
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_8_4.shtml
     * api: https://api.mch.weixin.qq.com/v3/vehicle/transactions/out-trade-no/{out_trade_no}
     *
     * @param chaXunDingDanRequest
     */
    ChaXunDingDanResponse chaXunDingDan(ChaXunDingDanRequest chaXunDingDanRequest);

    /**
     * 停车入场状态变更通知
     * descr: 停车入场状态变更通知API,最新更新时间：2021.08.06,从用户进入开通微信支付分停车服务的停车场（用户入场通知接口），到用户离场期间（扣款接口），这个时间段内如果停车入场状态变为可用或者不可用，微信会把相关状态变更情况（可用/不可用）异步发送给商户，回调url为调用用户入场通知接口时填写的notify_url字段。商户在收到停车入场状态变更通知后，需进行接收处理并返回应答。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_8_5.shtml
     * api: 通知url必须为直接可访问的url，不能携带参数。示例： “https://pay.weixin.qq.com/wxpay/pay.action”
     *
     * @param tingCheRuChangZhuangTaiBianGengTongZhiRequest
     */
    TingCheRuChangZhuangTaiBianGengTongZhiResponse tingCheRuChangZhuangTaiBianGengTongZhi(TingCheRuChangZhuangTaiBianGengTongZhiRequest tingCheRuChangZhuangTaiBianGengTongZhiRequest);

    /**
     * 订单支付结果通知
     * descr: 订单支付结果通知API,最新更新时间：2021.08.06,商户请求微信支付分停车服务扣费受理接口，会完成订单受理。订单实际支付完成后，微信支付会把订单支付结果信息发送给商户，商户需要接收处理，并返回应答。同时，如果由于用户余额不足等原因，微信支付会进行垫资，用户对该垫资单进行了还款以后，微信支付会把该笔订单还款信息通知到商户。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_8_6.shtml
     * api: 通知url必须为直接可访问的url，不能携带参数。示例： “https://pay.weixin.qq.com/wxpay/pay.action”
     *
     * @param dingDanZhiFuJieGuoTongZhiRequest
     */
    DingDanZhiFuJieGuoTongZhiResponse dingDanZhiFuJieGuoTongZhi(DingDanZhiFuJieGuoTongZhiRequest dingDanZhiFuJieGuoTongZhiRequest);

    /**
     * 小程序调起微信支付分停车服务开通页
     * descr: 小程序调起微信支付分停车服务开通页API,最新更新时间：2021.08.06,商户通过该接口，打开微信支付分开通小程序，引导用户进行服务开通。 来源小程序的appid必须与商户号相关联。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_8_7.shtml
     * api:
     *
     * @param xiaoChengXuDiaoQiWeiXinZhiFuFenTingCheFuWuKaiTongYeRequest
     */
    XiaoChengXuDiaoQiWeiXinZhiFuFenTingCheFuWuKaiTongYeResponse xiaoChengXuDiaoQiWeiXinZhiFuFenTingCheFuWuKaiTongYe(XiaoChengXuDiaoQiWeiXinZhiFuFenTingCheFuWuKaiTongYeRequest xiaoChengXuDiaoQiWeiXinZhiFuFenTingCheFuWuKaiTongYeRequest);

    /**
     * H5调起微信支付分停车服务开通页
     * descr: H5调起微信支付分停车服务开通页API,最新更新时间：2021.08.06,通过调用该接口打开微信支付分停车服务小程序，引导用户进行服务开通。 商户的来源appid必须要和商户号相关联。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_8_8.shtml
     * api:
     *
     * @param h5DiaoQiWeiXinZhiFuFenTingCheFuWuKaiTongYeRequest
     */
    H5DiaoQiWeiXinZhiFuFenTingCheFuWuKaiTongYeResponse h5DiaoQiWeiXinZhiFuFenTingCheFuWuKaiTongYe(H5DiaoQiWeiXinZhiFuFenTingCheFuWuKaiTongYeRequest h5DiaoQiWeiXinZhiFuFenTingCheFuWuKaiTongYeRequest);

    /**
     * APP拉起微信支付分停车服务开通页
     * descr: APP拉起微信支付分停车服务开通页API,最新更新时间：2021.08.06,通过调用该接口打开微信支付分停车服务小程序，引导用户进行服务开通。 商户的来源appid必须要和商户号相关联。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_8_9.shtml
     * api:
     *
     * @param aPPLaQiWeiXinZhiFuFenTingCheFuWuKaiTongYeRequest
     */
    APPLaQiWeiXinZhiFuFenTingCheFuWuKaiTongYeResponse aPPLaQiWeiXinZhiFuFenTingCheFuWuKaiTongYe(APPLaQiWeiXinZhiFuFenTingCheFuWuKaiTongYeRequest aPPLaQiWeiXinZhiFuFenTingCheFuWuKaiTongYeRequest);

    /**
     * 微信垫资还款
     * descr: 微信垫资还款API,最新更新时间：2021.11.29,该接口可以实现从商户的业务跳转至还款小程序。现在支持商户业务类型为小程序和APP。,未接入垫资功能的商户无需调用
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_8_10.shtml
     * api:
     *
     * @param weiXinDianZiHaiKuanRequest
     */
    WeiXinDianZiHaiKuanResponse weiXinDianZiHaiKuan(WeiXinDianZiHaiKuanRequest weiXinDianZiHaiKuanRequest);

    /**
     * 申请退款
     * descr: 申请退款API,最新更新时间：2022.08.29,当交易发生之后一年内，由于买家或者卖家的原因需要退款时，卖家可以通过退款接口将支付金额退还给买家，微信支付将在收到退款请求并且验证成功之后，将支付款按原路退还至买家账号上。,退款状态转变如下：
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_8_11.shtml
     * api: https://api.mch.weixin.qq.com/v3/refund/domestic/refunds
     *
     * @param shenQingTuiKuanRequest
     */
    ShenQingTuiKuanResponse shenQingTuiKuan(ShenQingTuiKuanRequest shenQingTuiKuanRequest);

    /**
     * 退款结果通知
     * descr: 退款结果通知API,最新更新时间：2021.01.15,退款状态改变后，微信会把相关退款结果发送给商户。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_8_12.shtml
     * api: 通知url必须为直接可访问的url，不能携带参数。示例：“https://pay.weixin.qq.com/wxpay/pay.action”
     *
     * @param tuiKuanJieGuoTongZhiRequest
     */
    TuiKuanJieGuoTongZhiResponse tuiKuanJieGuoTongZhi(TuiKuanJieGuoTongZhiRequest tuiKuanJieGuoTongZhiRequest);

    /**
     * 查询单笔退款
     * descr: 查询单笔退款API,最新更新时间：2022.08.29,提交退款申请后，通过调用该接口查询退款状态。退款有一定延时，建议在提交退款申请后1分钟发起查询退款状态，一般来说零钱支付的退款5分钟内到账，银行卡支付的退款1-3个工作日到账。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter8_8_13.shtml
     * api: https://api.mch.weixin.qq.com/v3/refund/domestic/refunds/{out_refund_no}
     *
     * @param chaXunDanBiTuiKuanRequest
     */
    ChaXunDanBiTuiKuanResponse chaXunDanBiTuiKuan(ChaXunDanBiTuiKuanRequest chaXunDanBiTuiKuanRequest);
}