package org.dows.sdk.weixin.register.management;

/**
 * @author lait.zhang@gmail.com
 * @description fastRegistrationOfficalaccountApi
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