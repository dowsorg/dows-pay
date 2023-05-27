package org.dows.sdk.weixin.register.management;

import org.dows.sdk.weixin.register.management.request.RegisterMiniprogramByOffiaccountRequest;
import org.dows.sdk.weixin.register.management.response.RegisterMiniprogramByOffiaccountResponse;

/**
 * @author
 * @description 调用方式以及出入参和HTTPS相同，仅是调用的token不同该接口所属的权限集id为：27服务商获得其中之一权限集授权后，可通过使用代商家进行调用
 * @date
 */
public interface FastRegistrationOfficalaccountApi {
    /**
     * @param registerMiniprogramByOffiaccountRequest
     */
    RegisterMiniprogramByOffiaccountResponse registerMiniprogramByOffiaccount(RegisterMiniprogramByOffiaccountRequest registerMiniprogramByOffiaccountRequest);


}
