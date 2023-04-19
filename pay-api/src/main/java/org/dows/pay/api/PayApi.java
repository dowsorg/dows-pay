package org.dows.pay.api;

import org.dows.app.api.mini.request.AppApplyRequest;
import org.dows.framework.api.Response;

import java.util.List;

public interface PayApi {

    /**
     * 小程序申请
     * @param appApplyRequest
     * @return
     */
    Response<Boolean> isvApply(AppApplyRequest appApplyRequest);




}
