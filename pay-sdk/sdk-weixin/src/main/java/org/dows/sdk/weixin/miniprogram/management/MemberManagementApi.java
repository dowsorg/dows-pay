package org.dows.sdk.weixin.miniprogram.management;

import org.dows.sdk.weixin.miniprogram.management.request.BindTesterRequest;
import org.dows.sdk.weixin.miniprogram.management.request.GetTesterRequest;
import org.dows.sdk.weixin.miniprogram.management.request.UnbindTesterRequest;
import org.dows.sdk.weixin.miniprogram.management.response.BindTesterResponse;
import org.dows.sdk.weixin.miniprogram.management.response.GetTesterResponse;
import org.dows.sdk.weixin.miniprogram.management.response.UnbindTesterResponse;

/**
 * @author
 * @description 调用方式以及出入参和HTTPS相同，仅是调用的token不同该接口所属的权限集id为：18服务商获得其中之一权限集授权后，可通过使用代商家进行调用
 * @date
 */
public interface MemberManagementApi {
    /**
     * 如果运营者同时也是该小程序的管理员，则无需绑定，管理员默认有体验权限。
     *
     * @param bindTesterRequest
     */
    BindTesterResponse bindTester(BindTesterRequest bindTesterRequest);

    /**
     * @param unbindTesterRequest
     */
    UnbindTesterResponse unbindTester(UnbindTesterRequest unbindTesterRequest);

    /**
     * @param getTesterRequest
     */
    GetTesterResponse getTester(GetTesterRequest getTesterRequest);


}
