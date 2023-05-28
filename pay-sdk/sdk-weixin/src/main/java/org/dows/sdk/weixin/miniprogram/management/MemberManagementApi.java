package org.dows.sdk.weixin.miniprogram.management;

/**
 * @description memberManagementApi
 * @author lait.zhang@gmail.com
 * @date  2023年5月28日 下午9:55:33
 */
public interface MemberManagementApi{

    /**
     * 如果运营者同时也是该小程序的管理员，则无需绑定，管理员默认有体验权限。
     * https://api.weixin.qq.com/wxa/bind_tester?access_token=ACCESS_TOKEN
     * 
     * @param bindTesterRequest
     * 
     */
    BindTesterResponse bindTester(BindTesterRequest bindTesterRequest);

    /**
     * 
     * https://api.weixin.qq.com/wxa/unbind_tester?access_token=ACCESS_TOKEN
     * 
     * @param unbindTesterRequest
     * 
     */
    UnbindTesterResponse unbindTester(UnbindTesterRequest unbindTesterRequest);

    /**
     * 
     * https://api.weixin.qq.com/wxa/memberauth?access_token=ACCESS_TOKEN
     * 
     * @param getTesterRequest
     * 
     */
    GetTesterResponse getTester(GetTesterRequest getTesterRequest);
}