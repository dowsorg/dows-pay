package org.dows.sdk.weixin.register.management;

/**
 * 
 */
public interface fastRegistrationOfficalaccount{

    /**
     * 
     * https://api.weixin.qq.com/cgi-bin/account/fastregister?access_token=ACCESS_TOKEN
     * 
     * @param registerMiniprogramByOffiaccountRequest
     * 
     */
    RegisterMiniprogramByOffiaccountResponse registerMiniprogramByOffiaccount(RegisterMiniprogramByOffiaccountRequest registerMiniprogramByOffiaccountRequest);
}