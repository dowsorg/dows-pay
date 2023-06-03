package org.dows.sdk.weixin.pay.jczf;

import org.dows.sdk.weixin.pay.jczf.request.*;
import org.dows.sdk.weixin.pay.jczf.response.*;

/**
 * Native支付
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:51
 */
public interface NativeZhiFuApi {

    /**
     * Native下单
     * descr: 统一下单API,最新更新时间：2020.05.26,商户Native支付统一下单接口，微信后台系统返回链接参数code_url，商户后台系统将code_url值生成二维码图片，用户使用微信客户端扫码后发起支付。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_4_1.shtml
     * api: https://api.mch.weixin.qq.com/v3/pay/partner/transactions/native
     *
     * @param nativeXiaDanRequest
     */
    NativeXiaDanResponse nativeXiaDan(NativeXiaDanRequest nativeXiaDanRequest);

    /**
     * 查询订单
     * descr: 查询订单API,最新更新时间：2021.1.14,商户可以通过查询订单接口主动查询订单状态，完成下一步的业务逻辑。查询订单状态可通过微信支付订单号或商户订单号两种方式查询
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_4_2.shtml
     * api: https://api.mch.weixin.qq.com/v3/pay/partner/transactions/id/{transaction_id},https://api.mch.weixin.qq.com/v3/pay/partner/transactions/out-trade-no/{out_trade_no}
     *
     * @param chaXunDingDanRequest
     */
    ChaXunDingDanResponse chaXunDingDan(ChaXunDingDanRequest chaXunDingDanRequest);

    /**
     * 关闭订单
     * descr: 关单API,最新更新时间：2020.05.26,以下情况需要调用关单接口：,1、商户订单支付失败需要生成新单号重新发起支付，要对原订单号调用关单，避免重复支付；,2、系统下单后，用户支付超时，系统退出不再受理，避免用户继续，请调用关单接口。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_4_3.shtml
     * api: https://api.mch.weixin.qq.com/v3/pay/partner/transactions/out-trade-no/{out_trade_no}/close
     *
     * @param guanBiDingDanRequest
     */
    GuanBiDingDanResponse guanBiDingDan(GuanBiDingDanRequest guanBiDingDanRequest);

    /**
     * Native调起支付
     * descr: Native调起支付API,最新更新时间：2020.04.29,商户后台系统先调用微信支付的,接口，微信后台系统返回链接参数code_url，商户后台系统将code_url值生成二维码图片，用户使用微信客户端扫码后发起支付。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_4_4.shtml
     * api:
     *
     * @param nativeDiaoQiZhiFuRequest
     */
    NativeDiaoQiZhiFuResponse nativeDiaoQiZhiFu(NativeDiaoQiZhiFuRequest nativeDiaoQiZhiFuRequest);

    /**
     * 支付通知
     * descr: 支付通知API,最新更新时间：2022.03.04,微信支付通过支付通知接口将用户支付成功消息通知给商户
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_4_5.shtml
     * api:
     *
     * @param zhiFuTongZhiRequest
     */
    ZhiFuTongZhiResponse zhiFuTongZhi(ZhiFuTongZhiRequest zhiFuTongZhiRequest);

    /**
     * 申请退款
     * descr: 申请退款API,最新更新时间：2022.08.29,当交易发生之后一年内，由于买家或者卖家的原因需要退款时，卖家可以通过退款接口将支付金额退还给买家，微信支付将在收到退款请求并且验证成功之后，将支付款按原路退还至买家账号上。,退款状态转变如下：
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_4_9.shtml
     * api: https://api.mch.weixin.qq.com/v3/refund/domestic/refunds
     *
     * @param shenQingTuiKuanRequest
     */
    ShenQingTuiKuanResponse shenQingTuiKuan(ShenQingTuiKuanRequest shenQingTuiKuanRequest);

    /**
     * 查询单笔退款
     * descr: 查询单笔退款API,最新更新时间：2022.08.29,提交退款申请后，通过调用该接口查询退款状态。退款有一定延时，建议在提交退款申请后1分钟发起查询退款状态，一般来说零钱支付的退款5分钟内到账，银行卡支付的退款1-3个工作日到账。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_4_10.shtml
     * api: https://api.mch.weixin.qq.com/v3/refund/domestic/refunds/{out_refund_no}
     *
     * @param chaXunDanBiTuiKuanRequest
     */
    ChaXunDanBiTuiKuanResponse chaXunDanBiTuiKuan(ChaXunDanBiTuiKuanRequest chaXunDanBiTuiKuanRequest);

    /**
     * 退款结果通知
     * descr: 退款结果通知API,最新更新时间：2021.01.15,退款状态改变后，微信会把相关退款结果发送给商户。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_4_11.shtml
     * api: 通知url必须为直接可访问的url，不能携带参数。示例：“https://pay.weixin.qq.com/wxpay/pay.action”
     *
     * @param tuiKuanJieGuoTongZhiRequest
     */
    TuiKuanJieGuoTongZhiResponse tuiKuanJieGuoTongZhi(TuiKuanJieGuoTongZhiRequest tuiKuanJieGuoTongZhiRequest);

    /**
     * 申请交易账单
     * descr: 申请交易账单API,最新更新时间：2021.12.10,微信支付按天提供交易账单文件，商户可以通过该接口获取账单文件的下载地址。文件内包含交易相关的金额、时间、营销等信息，供商户核对订单、退款、银行到账等情况。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_4_6.shtml
     * api: https://api.mch.weixin.qq.com/v3/bill/tradebill
     *
     * @param shenQingJiaoYiZhangDanRequest
     */
    ShenQingJiaoYiZhangDanResponse shenQingJiaoYiZhangDan(ShenQingJiaoYiZhangDanRequest shenQingJiaoYiZhangDanRequest);

    /**
     * 申请资金账单
     * descr: 申请资金账单API,最新更新时间：2021.12.10,微信支付按天提供微信支付账户的资金流水账单文件，商户可以通过该接口获取账单文件的下载地址。文件内包含该账户资金操作相关的业务单号、收支金额、记账时间等信息，供商户进行核对。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_4_7.shtml
     * api: https://api.mch.weixin.qq.com/v3/bill/fundflowbill
     *
     * @param shenQingZiJinZhangDanRequest
     */
    ShenQingZiJinZhangDanResponse shenQingZiJinZhangDan(ShenQingZiJinZhangDanRequest shenQingZiJinZhangDanRequest);

    /**
     * 申请单个子商户资金账单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_4_12.shtml
     * api:
     *
     * @param shenQingDanGeZiShangHuZiJinZhangDanRequest
     */
    ShenQingDanGeZiShangHuZiJinZhangDanResponse shenQingDanGeZiShangHuZiJinZhangDan(ShenQingDanGeZiShangHuZiJinZhangDanRequest shenQingDanGeZiShangHuZiJinZhangDanRequest);

    /**
     * 下载账单
     * descr: 下载账单API,最新更新时间：2021.12.10,下载账单API为通用接口，交易/资金账单都可以通过该接口获取到对应的账单。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_4_8.shtml
     * api: 通过申请账单接口获取到“download_url”，URL有效期30s
     *
     * @param xiaZaiZhangDanRequest
     */
    XiaZaiZhangDanResponse xiaZaiZhangDan(XiaZaiZhangDanRequest xiaZaiZhangDanRequest);
}