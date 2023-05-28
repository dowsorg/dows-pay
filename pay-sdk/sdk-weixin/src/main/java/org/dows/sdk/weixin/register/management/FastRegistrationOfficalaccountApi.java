package org.dows.sdk.weixin.register.management;

import org.dows.sdk.weixin.register.management.request.RegisterMiniprogramByOffiaccountRequest;
import org.dows.sdk.weixin.register.management.response.RegisterMiniprogramByOffiaccountResponse;

/**
 * @author lait.zhang@gmail.com
 * @description fastRegistrationOfficalaccountApi
 * @date 2023年5月28日 下午9:55:33
 */
public interface FastRegistrationOfficalaccountApi {

    /**
     * https://api.weixin.qq.com/cgi-bin/account/fastregister?access_token=ACCESS_TOKEN
     *
     * @param registerMiniprogramByOffiaccountRequest
     */
    RegisterMiniprogramByOffiaccountResponse registerMiniprogramByOffiaccount(RegisterMiniprogramByOffiaccountRequest registerMiniprogramByOffiaccountRequest);
}