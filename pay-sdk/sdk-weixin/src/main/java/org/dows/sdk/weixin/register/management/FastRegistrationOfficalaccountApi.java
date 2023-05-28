package org.dows.sdk.weixin.register.management;

/**
 * @description fastRegistrationOfficalaccountApi
 * @author lait.zhang@gmail.com
 * @date  2023年5月28日 下午9:55:33
 */
public interface FastRegistrationOfficalaccountApi{

    /**
     * 
     * https://api.weixin.qq.com/cgi-bin/account/fastregister?access_token=ACCESS_TOKEN
     * 
     * @param registerMiniprogramByOffiaccountRequest
     * 
     */
    RegisterMiniprogramByOffiaccountResponse registerMiniprogramByOffiaccount(RegisterMiniprogramByOffiaccountRequest registerMiniprogramByOffiaccountRequest);
}