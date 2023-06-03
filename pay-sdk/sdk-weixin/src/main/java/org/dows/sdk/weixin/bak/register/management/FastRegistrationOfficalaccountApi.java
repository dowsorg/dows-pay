package org.dows.sdk.weixin.bak.register.management;

import org.dows.sdk.weixin.bak.register.management.request.RegisterMiniprogramByOffiaccountRequest;
import org.dows.sdk.weixin.bak.register.management.response.RegisterMiniprogramByOffiaccountResponse;

/**
 * @author lait.zhang@gmail.com
 * @description fastRegistrationOfficalaccountApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface FastRegistrationOfficalaccountApi {

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/register-management/fast-registration-officalaccount/registerMiniprogramByOffiaccount.html
     * api: https://api.weixin.qq.com/cgi-bin/account/fastregister?access_token=ACCESS_TOKEN
     *
     * @param registerMiniprogramByOffiaccountRequest
     */
    RegisterMiniprogramByOffiaccountResponse registerMiniprogramByOffiaccount(RegisterMiniprogramByOffiaccountRequest registerMiniprogramByOffiaccountRequest);
}