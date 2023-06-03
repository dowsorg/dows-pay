package org.dows.sdk.weixin.pay.jczf;

import org.dows.sdk.weixin.pay.jczf.request.*;
import org.dows.sdk.weixin.pay.jczf.response.*;

/**
 * 合单支付
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:51
 */
public interface HeDanZhiFuApi {

    /**
     * 合单APP下单
     * descr: 合单APP下单API,最新更新时间：2022.05.31,使用合单支付接口，用户只输入一次密码，即可完成多个订单的支付。目前最少一次可支持2笔，最多一次10笔订单进行合单支付。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_1.shtml
     * api: https://api.mch.weixin.qq.com/v3/combine-transactions/app
     *
     * @param heDanAPPXiaDanRequest
     */
    HeDanAPPXiaDanResponse heDanAPPXiaDan(HeDanAPPXiaDanRequest heDanAPPXiaDanRequest);

    /**
     * 合单H5下单
     * descr: 合单H5下单API,最新更新时间：2022.05.31,使用合单支付接口，用户只输入一次密码，即可完成多个订单的支付。目前最少一次可支持2笔，最多一次10笔订单进行合单支付。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_2.shtml
     * api: https://api.mch.weixin.qq.com/v3/combine-transactions/h5
     *
     * @param heDanH5XiaDanRequest
     */
    HeDanH5XiaDanResponse heDanH5XiaDan(HeDanH5XiaDanRequest heDanH5XiaDanRequest);

    /**
     * 合单JSAPI下单
     * descr: 合单JSAPI下单API,最新更新时间：2022.05.31,使用合单支付接口，用户只输入一次密码，即可完成多个订单的支付。目前最少一次可支持2笔，最多一次10笔订单进行合单支付。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_3.shtml
     * api: https://api.mch.weixin.qq.com/v3/combine-transactions/jsapi
     *
     * @param heDanJSAPIXiaDanRequest
     */
    HeDanJSAPIXiaDanResponse heDanJSAPIXiaDan(HeDanJSAPIXiaDanRequest heDanJSAPIXiaDanRequest);

    /**
     * 合单小程序下单
     * descr: 合单小程序下单API,最新更新时间：2022.05.31,使用合单支付接口，用户只输入一次密码，即可完成多个订单的支付。目前最少一次可支持2笔，最多一次10笔订单进行合单支付。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_4.shtml
     * api: https://api.mch.weixin.qq.com/v3/combine-transactions/jsapi
     *
     * @param heDanXiaoChengXuXiaDanRequest
     */
    HeDanXiaoChengXuXiaDanResponse heDanXiaoChengXuXiaDan(HeDanXiaoChengXuXiaDanRequest heDanXiaoChengXuXiaDanRequest);

    /**
     * 合单Native下单
     * descr: 合单Native下单API,最新更新时间：2022.05.31,使用合单支付接口，用户只输入一次密码，即可完成多个订单的支付。目前最少一次可支持2笔，最多一次10笔订单进行合单支付。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_5.shtml
     * api: https://api.mch.weixin.qq.com/v3/combine-transactions/native
     *
     * @param heDanNativeXiaDanRequest
     */
    HeDanNativeXiaDanResponse heDanNativeXiaDan(HeDanNativeXiaDanRequest heDanNativeXiaDanRequest);

    /**
     * APP调起支付
     * descr: APP调起支付API,最新更新时间：2020.09.29,通过APP下单接口获取到发起支付的必要参数prepay_id，可以按照接口定义中的规则，使用微信支付提供的SDK调起小程序支付。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_6.shtml
     * api:
     *
     * @param aPPDiaoQiZhiFuRequest
     */
    APPDiaoQiZhiFuResponse aPPDiaoQiZhiFu(APPDiaoQiZhiFuRequest aPPDiaoQiZhiFuRequest);

    /**
     * H5调起支付
     * descr: H5调起支付API,最新更新时间：2020.05.26,商户后台系统先调用微信支付的,接口，微信后台系统返回链接参数h5_url，用户使用微信外部的浏览器访问该h5_url地址调起微信支付中间页
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_7.shtml
     * api:
     *
     * @param h5DiaoQiZhiFuRequest
     */
    H5DiaoQiZhiFuResponse h5DiaoQiZhiFu(H5DiaoQiZhiFuRequest h5DiaoQiZhiFuRequest);

    /**
     * JSAPI调起支付
     * descr: JSAPI调起支付API,最新更新时间：2023.05.18,通过JSAPI下单接口获取到发起支付的必要参数prepay_id，然后使用微信支付提供的前端JS方法调起公众号支付。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_8.shtml
     * api:
     *
     * @param jSAPIDiaoQiZhiFuRequest
     */
    JSAPIDiaoQiZhiFuResponse jSAPIDiaoQiZhiFu(JSAPIDiaoQiZhiFuRequest jSAPIDiaoQiZhiFuRequest);

    /**
     * 小程序调起支付
     * descr: 小程序调起支付API,最新更新时间：2020.05.26,通过JSAPI下单接口获取到发起支付的必要参数prepay_id，然后使用微信支付提供的小程序方法调起小程序支付。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_9.shtml
     * api:
     *
     * @param xiaoChengXuDiaoQiZhiFuRequest
     */
    XiaoChengXuDiaoQiZhiFuResponse xiaoChengXuDiaoQiZhiFu(XiaoChengXuDiaoQiZhiFuRequest xiaoChengXuDiaoQiZhiFuRequest);

    /**
     * Native调起支付
     * descr: Native调起支付API,最新更新时间：2020.04.29,商户后台系统先调用微信支付的,接口，微信后台系统返回链接参数code_url，商户后台系统将code_url值生成二维码图片，用户使用微信客户端扫码后发起支付。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_10.shtml
     * api:
     *
     * @param nativeDiaoQiZhiFuRequest
     */
    NativeDiaoQiZhiFuResponse nativeDiaoQiZhiFu(NativeDiaoQiZhiFuRequest nativeDiaoQiZhiFuRequest);

    /**
     * 合单查询订单
     * descr: 合单查询订单API,最新更新时间：2021.04.21,商户通过合单查询订单API查询订单状态，完成下一步的业务逻辑。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_11.shtml
     * api: https://api.mch.weixin.qq.com/v3/combine-transactions/out-trade-no/{combine_out_trade_no}
     *
     * @param heDanChaXunDingDanRequest
     */
    HeDanChaXunDingDanResponse heDanChaXunDingDan(HeDanChaXunDingDanRequest heDanChaXunDingDanRequest);

    /**
     * 合单关闭订单
     * descr: 合单关闭订单API,最新更新时间：2022.05.18,合单支付订单只能使用此合单关单api完成关单。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_12.shtml
     * api: https://api.mch.weixin.qq.com/v3/combine-transactions/out-trade-no/{combine_out_trade_no}/close
     *
     * @param heDanGuanBiDingDanRequest
     */
    HeDanGuanBiDingDanResponse heDanGuanBiDingDan(HeDanGuanBiDingDanRequest heDanGuanBiDingDanRequest);

    /**
     * 支付通知
     * descr: 支付通知API,最新更新时间：2019.09.10,微信支付通过支付通知接口将用户支付成功消息通知给商户
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_13.shtml
     * api: 通知url必须为直接可访问的url，不能携带参数。示例： “https://pay.weixin.qq.com/wxpay/pay.action”
     *
     * @param zhiFuTongZhiRequest
     */
    ZhiFuTongZhiResponse zhiFuTongZhi(ZhiFuTongZhiRequest zhiFuTongZhiRequest);

    /**
     * 申请退款
     * descr: 申请退款API,最新更新时间：2022.08.29,当交易发生之后一年内，由于买家或者卖家的原因需要退款时，卖家可以通过退款接口将支付金额退还给买家，微信支付将在收到退款请求并且验证成功之后，将支付款按原路退还至买家账号上。,退款状态转变如下：
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_14.shtml
     * api: https://api.mch.weixin.qq.com/v3/refund/domestic/refunds
     *
     * @param shenQingTuiKuanRequest
     */
    ShenQingTuiKuanResponse shenQingTuiKuan(ShenQingTuiKuanRequest shenQingTuiKuanRequest);

    /**
     * 查询单笔退款
     * descr: 查询单笔退款API,最新更新时间：2022.08.29,提交退款申请后，通过调用该接口查询退款状态。退款有一定延时，建议在提交退款申请后1分钟发起查询退款状态，一般来说零钱支付的退款5分钟内到账，银行卡支付的退款1-3个工作日到账。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_15.shtml
     * api: https://api.mch.weixin.qq.com/v3/refund/domestic/refunds/{out_refund_no}
     *
     * @param chaXunDanBiTuiKuanRequest
     */
    ChaXunDanBiTuiKuanResponse chaXunDanBiTuiKuan(ChaXunDanBiTuiKuanRequest chaXunDanBiTuiKuanRequest);

    /**
     * 退款结果通知
     * descr: 退款结果通知API,最新更新时间：2021.01.15,退款状态改变后，微信会把相关退款结果发送给商户。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_16.shtml
     * api: 通知url必须为直接可访问的url，不能携带参数。示例：“https://pay.weixin.qq.com/wxpay/pay.action”
     *
     * @param tuiKuanJieGuoTongZhiRequest
     */
    TuiKuanJieGuoTongZhiResponse tuiKuanJieGuoTongZhi(TuiKuanJieGuoTongZhiRequest tuiKuanJieGuoTongZhiRequest);

    /**
     * 申请交易账单
     * descr: 申请交易账单API,最新更新时间：2021.12.10,微信支付按天提供交易账单文件，商户可以通过该接口获取账单文件的下载地址。文件内包含交易相关的金额、时间、营销等信息，供商户核对订单、退款、银行到账等情况。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_17.shtml
     * api: https://api.mch.weixin.qq.com/v3/bill/tradebill
     *
     * @param shenQingJiaoYiZhangDanRequest
     */
    ShenQingJiaoYiZhangDanResponse shenQingJiaoYiZhangDan(ShenQingJiaoYiZhangDanRequest shenQingJiaoYiZhangDanRequest);

    /**
     * 申请资金账单
     * descr: 申请资金账单API,最新更新时间：2021.12.10,微信支付按天提供微信支付账户的资金流水账单文件，商户可以通过该接口获取账单文件的下载地址。文件内包含该账户资金操作相关的业务单号、收支金额、记账时间等信息，供商户进行核对。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_18.shtml
     * api: https://api.mch.weixin.qq.com/v3/bill/fundflowbill
     *
     * @param shenQingZiJinZhangDanRequest
     */
    ShenQingZiJinZhangDanResponse shenQingZiJinZhangDan(ShenQingZiJinZhangDanRequest shenQingZiJinZhangDanRequest);

    /**
     * 申请单个子商户资金账单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_20.shtml
     * api:
     *
     * @param shenQingDanGeZiShangHuZiJinZhangDanRequest
     */
    ShenQingDanGeZiShangHuZiJinZhangDanResponse shenQingDanGeZiShangHuZiJinZhangDan(ShenQingDanGeZiShangHuZiJinZhangDanRequest shenQingDanGeZiShangHuZiJinZhangDanRequest);

    /**
     * 下载账单
     * descr: 下载账单API,最新更新时间：2021.12.10,下载账单API为通用接口，交易/资金账单都可以通过该接口获取到对应的账单。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_19.shtml
     * api: 通过申请账单接口获取到“download_url”，URL有效期30s
     *
     * @param xiaZaiZhangDanRequest
     */
    XiaZaiZhangDanResponse xiaZaiZhangDan(XiaZaiZhangDanRequest xiaZaiZhangDanRequest);

    /**
     * 付款码支付
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/index.shtml#menu00
     * api:
     *
     * @param fuKuanMaZhiFuRequest
     */
    FuKuanMaZhiFuResponse fuKuanMaZhiFu(FuKuanMaZhiFuRequest fuKuanMaZhiFuRequest);
}