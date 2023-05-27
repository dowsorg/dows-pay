package org.dows.sdk.weixin.miniprogram.management;

import org.dows.sdk.weixin.miniprogram.management.request.ThirdpartyCode2SessionRequest;
import org.dows.sdk.weixin.miniprogram.management.response.ThirdpartyCode2SessionResponse;

/**
 * @author
 * @description
 * @date
 */
public interface LoginApi {
    /**
     * @param thirdpartyCode2SessionRequest
     */
    ThirdpartyCode2SessionResponse thirdpartyCode2Session(ThirdpartyCode2SessionRequest thirdpartyCode2SessionRequest);

}
