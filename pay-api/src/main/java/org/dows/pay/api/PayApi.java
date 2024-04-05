package org.dows.pay.api;

import org.dows.framework.api.Response;
import org.dows.pay.api.request.AppApplyRequest;
import org.dows.pay.api.request.PayApplyStatusReq;
import org.dows.pay.api.request.PayCreateIsvRequest;
import org.dows.pay.api.request.PayQueryReq;
import org.dows.pay.api.request.ScanPayApplyRes;
import org.dows.pay.api.request.ScanPayReq;
import org.dows.pay.api.request.WechatMiniUploadRequest;
import org.dows.pay.api.response.PayQueryRes;

import me.chanjar.weixin.open.bean.result.WxOpenQueryAuthResult;
import org.dows.pay.api.response.PayTransactionRes;

import java.util.List;
import java.util.Map;

public interface PayApi {

    /**
     * 小程序申请以及小程序申请支付权限 合并
     *
     * @param appApplyRequest
     * @return
     */
    Response isvApply(AppApplyRequest appApplyRequest);

    /**
     * 小程序基本信息维护
     *
     * @param appApplyRequest
     * @return
     */
    Response miniBaseInfo(AppApplyRequest appApplyRequest);

    /**
     * 小程序申请 单独
     *
     * @param appApplyRequest
     * @return
     */
    Response fastRegisterApp(AppApplyRequest appApplyRequest);

    /**
     * 小程序申请支付权限 单独
     *
     * @param appApplyRequest
     * @return
     */
    Response applyForPaymentAuth(AppApplyRequest appApplyRequest);

    /**
     * 查询支付订单
     * 交易状态，枚举值：
     * SUCCESS：支付成功
     * REFUND：转入退款
     * NOTPAY：未支付
     * CLOSED：已关闭
     * REVOKED：已撤销（仅付款码支付会返回）
     * USERPAYING：用户支付中（仅付款码支付会返回）
     * PAYERROR：支付失败（仅付款码支付会返回）
     * @param req req
     * @return res
     */
    Response<PayQueryRes> queryPayOrder(PayQueryReq req);

    /**
     * 查询小程序申请状态(支付宝)
     *
     * @param appApplyRequest
     * @return
     */
    Response queryIsvMiniStatus(AppApplyRequest appApplyRequest);

    /**
     * 支付宝申请支付权限 单独
     *
     * @param appApplyRequest
     * @return
     */
    Response applyForPaymentlsv(PayCreateIsvRequest appApplyRequest);

    /**
     * 查询小程序申请支付权限结果
     *
     * @param applymentId
     * @return
     */
    Response queryApplymentStatus(String applymentId);

    /**
     * 查询小程序 支付状态
     * @param res
     * @return
     */
    Response queryPayApplyStatus(PayApplyStatusReq res);

    /**
     * 查询支付申请记录
     * @param req
     * @return
     */
    Response queryPayApply(PayApplyStatusReq req);

    /**
     * 上传模版小程序
     * @param request -
     * @return -
     */
    Response uploadWeChatMini(WechatMiniUploadRequest request);

    /**
     * 查询小程序名称审核状态
     * @param res
     * @return
     */
    Response getNickNameStatus(PayApplyStatusReq res);

    /**
     * 使用授权码获取授权信息
     * @param authorizationCode
     * @return
     */
    WxOpenQueryAuthResult apiQueryAuth(String authorizationCode);

    ScanPayApplyRes scanPay(ScanPayReq req);


    Map<String, PayTransactionRes> getPaymentTranAmount(List<String> orderIds);

}
