package org.dows.sdk.weixin;

import org.dows.sdk.weixin.request.BindOpenAccountRequest;
import org.dows.sdk.weixin.request.CreateOpenAccountRequest;
import org.dows.sdk.weixin.request.GetOpenAccountRequest;
import org.dows.sdk.weixin.request.UnbindOpenAccountRequest;
import org.dows.sdk.weixin.response.BindOpenAccountResponse;
import org.dows.sdk.weixin.response.CreateOpenAccountResponse;
import org.dows.sdk.weixin.response.GetOpenAccountResponse;
import org.dows.sdk.weixin.response.UnbindOpenAccountResponse;

/**
 * @author
 * @description 调用方式以及出入参和HTTPS相同，仅是调用的token不同该接口所属的权限集id为：24、25、60服务商获得其中之一权限集授权后，可通过使用代商家进行调用
 * @date
 */
public interface OpenplatformManagementApi {
    /**
     * 1、对于未认证的open帐号，只适用于open帐号通过接口创建的，且只适用于绑定同主体的帐号，以及最多只能绑定5个2、对于未认证的open帐号，但是是通过微信开放平台界面注册的，不可通过该接口进行绑定。
     *
     * @param bindOpenAccountRequest
     */
    BindOpenAccountResponse bindOpenAccount(BindOpenAccountRequest bindOpenAccountRequest);

    /**
     * 该 API 用于将一个公众号或小程序与指定开放平台帐号解绑。开发者须确认所指定帐号与当前该公众号或小程序所绑定的开放平台帐号一致。使用过程中如遇到问题，可在发帖交流。
     *
     * @param unbindOpenAccountRequest
     */
    UnbindOpenAccountResponse unbindOpenAccount(UnbindOpenAccountRequest unbindOpenAccountRequest);

    /**
     * 该 API 用于获取公众号或小程序所绑定的开放平台帐号。使用过程中如遇到问题，可在发帖交流。
     *
     * @param getOpenAccountRequest
     */
    GetOpenAccountResponse getOpenAccount(GetOpenAccountRequest getOpenAccountRequest);

    /**
     * @param createOpenAccountRequest
     */
    CreateOpenAccountResponse createOpenAccount(CreateOpenAccountRequest createOpenAccountRequest);

}
