package org.dows.sdk.weixin.open.dsjzcxcx;

import org.dows.sdk.weixin.open.dsjzcxcx.request.KuaiSuZhuCeGeRenXiaoChengXuRequest;
import org.dows.sdk.weixin.open.dsjzcxcx.response.KuaiSuZhuCeGeRenXiaoChengXuResponse;

/**
 * 注册个人小程序
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface ZhuCeGeRenXiaoChengXuApi {

    /**
     * 快速注册个人小程序
     * descr: 关于快速注册小程序的详细介绍以及使用步骤等请查看,，本文为快速注册小程序的接口文档。,注册成功失败的结果会向授权事件接收 URL 推送相关通知。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/register-management/fast-registration-ind/fastRegisterPersonalMp.html
     * api: https://api.weixin.qq.com/wxa/component/fastregisterpersonalweapp?action=create&component_access_token=ACCESS_TOKEN,POST https://api.weixin.qq.com/wxa/component/fastregisterpersonalweapp?action=query&component_access_token=ACCESS_TOKEN,<xml> <AppId><![CDATA[第三方平台appid]]></AppId> <CreateTime>1535442403</CreateTime> <InfoType><![CDATA[notify_third_fasteregister]]></InfoType> <appid>创建小程序appid</appid> <status>0</status> <auth_code>xxxxx第三方授权码</auth_code> <msg>OK</msg> <info> <wxuser><![CDATA[用户微信号]]></wxuser> <idname><![CDATA[用户姓名]]></wxidnnn> <component_phone><![CDATA[第三方联系电话]]></component_phone> </info> </xml>
     *
     * @param kuaiSuZhuCeGeRenXiaoChengXuRequest
     */
    KuaiSuZhuCeGeRenXiaoChengXuResponse kuaiSuZhuCeGeRenXiaoChengXu(KuaiSuZhuCeGeRenXiaoChengXuRequest kuaiSuZhuCeGeRenXiaoChengXuRequest);
}