package org.dows.pay.api;

import org.dows.app.api.mini.request.AppApplyRequest;
import org.dows.framework.api.Response;

public interface PayApi {

    /**
     * 小程序申请
     * @param appApplyRequest
     * @return
     */
    Response isvApply(AppApplyRequest appApplyRequest);

    /**
     * 小程序基本信息维护
     * @param appApplyRequest
     * @return
     */
    Response miniBaseInfo(AppApplyRequest appApplyRequest);



}
