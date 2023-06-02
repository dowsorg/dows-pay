package org.dows.sdk.weixin.open.开放平台帐号管理;

/**
 * @description 
 * @author lait.zhang@gmail.com
 * @date  2023年6月2日 下午3:34:20
 */
public interface 开放平台帐号管理Api{

    /**
     * description: 1、对于未认证的open帐号，只适用于open帐号通过接口创建的，且只适用于绑定同主体的帐号，以及最多只能绑定5个,2、对于未认证的open帐号，但是是通过微信开放平台界面注册的，不可通过该接口进行绑定。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//doc/oplatform/openApi/OpenApiDoc/openplatform-management/bindOpenAccount.html
     * api: https://api.weixin.qq.com/cgi-bin/open/bind?access_token=ACCESS_TOKEN
     * 
     * @param 绑定开放平台帐号Request
     * 
     */
    绑定开放平台帐号Response 绑定开放平台帐号(绑定开放平台帐号Request 绑定开放平台帐号Request);

    /**
     * description: 该 API 用于将一个公众号或小程序与指定开放平台帐号解绑。开发者须确认所指定帐号与当前该公众号或小程序所绑定的开放平台帐号一致。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//doc/oplatform/openApi/OpenApiDoc/openplatform-management/unbindOpenAccount.html
     * api: https://api.weixin.qq.com/cgi-bin/open/unbind?access_token=ACCESS_TOKEN
     * 
     * @param 解除绑定开放平台帐号Request
     * 
     */
    解除绑定开放平台帐号Response 解除绑定开放平台帐号(解除绑定开放平台帐号Request 解除绑定开放平台帐号Request);

    /**
     * description: 该 API 用于获取公众号或小程序所绑定的开放平台帐号。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//doc/oplatform/openApi/OpenApiDoc/openplatform-management/getOpenAccount.html
     * api: https://api.weixin.qq.com/cgi-bin/open/get?access_token=ACCESS_TOKEN
     * 
     * @param 获取开放平台帐号Request
     * 
     */
    获取开放平台帐号Response 获取开放平台帐号(获取开放平台帐号Request 获取开放平台帐号Request);

    /**
     * description: 
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//doc/oplatform/openApi/OpenApiDoc/openplatform-management/createOpenAccount.html
     * api: https://api.weixin.qq.com/cgi-bin/open/create?access_token=ACCESS_TOKEN
     * 
     * @param 创建开放平台帐号Request
     * 
     */
    创建开放平台帐号Response 创建开放平台帐号(创建开放平台帐号Request 创建开放平台帐号Request);
}