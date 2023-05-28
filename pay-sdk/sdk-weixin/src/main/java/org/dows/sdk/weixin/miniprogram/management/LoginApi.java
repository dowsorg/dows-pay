package org.dows.sdk.weixin.miniprogram.management;

/**
 * @author lait.zhang@gmail.com
 * @description loginApi
 */
public interface LoginApi{

    /**
     * 
     * https://api.weixin.qq.com/sns/component/jscode2session?component_access_token=ACCESS_TOKEN
     * 
     * @param thirdpartyCode2SessionRequest
     * 
     */
    ThirdpartyCode2SessionResponse thirdpartyCode2Session(ThirdpartyCode2SessionRequest thirdpartyCode2SessionRequest);
}