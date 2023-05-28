package org.dows.sdk.weixin;

/**
 * 
 */
public interface openplatformManagement{

    /**
     * 1、对于未认证的open帐号，只适用于open帐号通过接口创建的，且只适用于绑定同主体的帐号，以及最多只能绑定5个2、对于未认证的open帐号，但是是通过微信开放平台界面注册的，不可通过该接口进行绑定。
     * https://api.weixin.qq.com/cgi-bin/open/bind?access_token=ACCESS_TOKEN
     * 
     * @param bindOpenAccountRequest
     * 
     */
    BindOpenAccountResponse bindOpenAccount(BindOpenAccountRequest bindOpenAccountRequest);

    /**
     * 该 API 用于将一个公众号或小程序与指定开放平台帐号解绑。开发者须确认所指定帐号与当前该公众号或小程序所绑定的开放平台帐号一致。使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/cgi-bin/open/unbind?access_token=ACCESS_TOKEN
     * 
     * @param unbindOpenAccountRequest
     * 
     */
    UnbindOpenAccountResponse unbindOpenAccount(UnbindOpenAccountRequest unbindOpenAccountRequest);

    /**
     * 该 API 用于获取公众号或小程序所绑定的开放平台帐号。使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/cgi-bin/open/get?access_token=ACCESS_TOKEN
     * 
     * @param getOpenAccountRequest
     * 
     */
    GetOpenAccountResponse getOpenAccount(GetOpenAccountRequest getOpenAccountRequest);

    /**
     * 
     * https://api.weixin.qq.com/cgi-bin/open/create?access_token=ACCESS_TOKEN
     * 
     * @param createOpenAccountRequest
     * 
     */
    CreateOpenAccountResponse createOpenAccount(CreateOpenAccountRequest createOpenAccountRequest);
}