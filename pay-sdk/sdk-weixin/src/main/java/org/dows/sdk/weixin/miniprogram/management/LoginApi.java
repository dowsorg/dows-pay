package org.dows.sdk.weixin.miniprogram.management;

import org.dows.sdk.weixin.miniprogram.management.request.ThirdpartyCode2SessionRequest;
import org.dows.sdk.weixin.miniprogram.management.response.ThirdpartyCode2SessionResponse;

/**
 * @author lait.zhang@gmail.com
 * @Date 2023年5月28日 下午9:25:34
 * @description loginApi
 */
public interface LoginApi {

    /**
     * https://api.weixin.qq.com/sns/component/jscode2session?component_access_token=ACCESS_TOKEN
     *
     * @param thirdpartyCode2SessionRequest
     */
    ThirdpartyCode2SessionResponse thirdpartyCode2Session(ThirdpartyCode2SessionRequest thirdpartyCode2SessionRequest);
}