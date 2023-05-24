package org.dows.pay.api;

import org.dows.app.api.mini.request.AppApplyRequest;
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
}
