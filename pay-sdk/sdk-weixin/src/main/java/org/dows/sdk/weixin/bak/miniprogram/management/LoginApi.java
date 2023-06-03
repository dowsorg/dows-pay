package org.dows.sdk.weixin.bak.miniprogram.management;

import org.dows.sdk.weixin.bak.miniprogram.management.request.ThirdpartyCode2SessionRequest;
import org.dows.sdk.weixin.bak.miniprogram.management.response.ThirdpartyCode2SessionResponse;

/**
 * @author lait.zhang@gmail.com
 * @description loginApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface LoginApi {

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/login/thirdpartyCode2Session.html
     * api: https://api.weixin.qq.com/sns/component/jscode2session?component_access_token=ACCESS_TOKEN
     *
     * @param thirdpartyCode2SessionRequest
     */
    ThirdpartyCode2SessionResponse thirdpartyCode2Session(ThirdpartyCode2SessionRequest thirdpartyCode2SessionRequest);
}