package org.dows.sdk.weixin.bak.miniprogram.management;

import org.dows.sdk.weixin.bak.miniprogram.management.request.BindTesterRequest;
import org.dows.sdk.weixin.bak.miniprogram.management.request.GetTesterRequest;
import org.dows.sdk.weixin.bak.miniprogram.management.request.UnbindTesterRequest;
import org.dows.sdk.weixin.bak.miniprogram.management.response.BindTesterResponse;
import org.dows.sdk.weixin.bak.miniprogram.management.response.GetTesterResponse;
import org.dows.sdk.weixin.bak.miniprogram.management.response.UnbindTesterResponse;

/**
 * @author lait.zhang@gmail.com
 * @description memberManagementApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface MemberManagementApi {

    /**
     * description: 如果运营者同时也是该小程序的管理员，则无需绑定，管理员默认有体验权限。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/member-management/bindTester.html
     * api: https://api.weixin.qq.com/wxa/bind_tester?access_token=ACCESS_TOKEN
     *
     * @param bindTesterRequest
     */
    BindTesterResponse bindTester(BindTesterRequest bindTesterRequest);

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/member-management/unbindTester.html
     * api: https://api.weixin.qq.com/wxa/unbind_tester?access_token=ACCESS_TOKEN
     *
     * @param unbindTesterRequest
     */
    UnbindTesterResponse unbindTester(UnbindTesterRequest unbindTesterRequest);

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/member-management/getTester.html
     * api: https://api.weixin.qq.com/wxa/memberauth?access_token=ACCESS_TOKEN
     *
     * @param getTesterRequest
     */
    GetTesterResponse getTester(GetTesterRequest getTesterRequest);
}