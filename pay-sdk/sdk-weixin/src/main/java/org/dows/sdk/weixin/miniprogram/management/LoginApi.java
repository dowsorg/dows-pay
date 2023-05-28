package org.dows.sdk.weixin.miniprogram.management;

/**
 * @description loginApi
 * @author lait.zhang@gmail.com
 * @date  2023年5月28日 下午9:55:33
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