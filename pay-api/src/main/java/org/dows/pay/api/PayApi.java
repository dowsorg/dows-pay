package org.dows.pay.api;

import org.dows.app.api.mini.request.AppApplyRequest;
import org.dows.app.api.mini.request.PayApplyStatusReq;
import org.dows.app.api.mini.request.WechatMiniUploadRequest;
import org.dows.app.api.mini.response.PayApplyStatusRes;
import org.dows.framework.api.Response;

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

}
