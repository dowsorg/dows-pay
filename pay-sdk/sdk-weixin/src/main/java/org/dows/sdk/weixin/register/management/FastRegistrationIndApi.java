package org.dows.sdk.weixin.register.management;

/**
 * @description fastRegistrationIndApi
 * @author lait.zhang@gmail.com
 * @date  2023年5月28日 下午9:55:33
 */
public interface FastRegistrationIndApi{

    /**
     * 关于快速注册小程序的详细介绍以及使用步骤等请查看，本文为快速注册小程序的接口文档。注册成功失败的结果会向授权事件接收 URL 推送相关通知。
     * https://api.weixin.qq.com/wxa/component/fastregisterpersonalweapp?action=create&component_access_token=ACCESS_TOKENPOST https://api.weixin.qq.com/wxa/component/fastregisterpersonalweapp?action=query&component_access_token=ACCESS_TOKEN<xml> <AppId><![CDATA[第三方平台appid]]></AppId> <CreateTime>1535442403</CreateTime> <InfoType><![CDATA[notify_third_fasteregister]]></InfoType> <appid>创建小程序appid</appid> <status>0</status> <auth_code>xxxxx第三方授权码</auth_code> <msg>OK</msg> <info> <wxuser><![CDATA[用户微信号]]></wxuser> <idname><![CDATA[用户姓名]]></wxidnnn> <component_phone><![CDATA[第三方联系电话]]></component_phone> </info> </xml>
     * 
     * @param fastRegisterPersonalMpRequest
     * 
     */
    FastRegisterPersonalMpResponse fastRegisterPersonalMp(FastRegisterPersonalMpRequest fastRegisterPersonalMpRequest);
}