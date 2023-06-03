package org.dows.sdk.weixin.bak.register.management;

import org.dows.sdk.weixin.bak.register.management.request.FastRegisterPersonalMpRequest;
import org.dows.sdk.weixin.bak.register.management.response.FastRegisterPersonalMpResponse;

/**
 * @author lait.zhang@gmail.com
 * @description fastRegistrationIndApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface FastRegistrationIndApi {

    /**
     * description: 关于快速注册小程序的详细介绍以及使用步骤等请查看，本文为快速注册小程序的接口文档。注册成功失败的结果会向授权事件接收 URL 推送相关通知。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/register-management/fast-registration-ind/fastRegisterPersonalMp.html
     * api: https://api.weixin.qq.com/wxa/component/fastregisterpersonalweapp?action=create&component_access_token=ACCESS_TOKENPOST https://api.weixin.qq.com/wxa/component/fastregisterpersonalweapp?action=query&component_access_token=ACCESS_TOKEN<xml> <AppId><![CDATA[第三方平台appid]]></AppId> <CreateTime>1535442403</CreateTime> <InfoType><![CDATA[notify_third_fasteregister]]></InfoType> <appid>创建小程序appid</appid> <status>0</status> <auth_code>xxxxx第三方授权码</auth_code> <msg>OK</msg> <info> <wxuser><![CDATA[用户微信号]]></wxuser> <idname><![CDATA[用户姓名]]></wxidnnn> <component_phone><![CDATA[第三方联系电话]]></component_phone> </info> </xml>
     *
     * @param fastRegisterPersonalMpRequest
     */
    FastRegisterPersonalMpResponse fastRegisterPersonalMp(FastRegisterPersonalMpRequest fastRegisterPersonalMpRequest);
}