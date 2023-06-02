package org.dows.sdk.weixin.open.授权帐号管理;

/**
 * @description 
 * @author lait.zhang@gmail.com
 * @date  2023年6月2日 下午3:34:20
 */
public interface 授权帐号管理Api{

    /**
     * description: 使用本 API 拉取当前所有已授权的帐号基本信息。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//doc/oplatform/openApi/OpenApiDoc/authorization-management/getAuthorizerList.html
     * api: https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_list?access_token=ACCESS_TOKEN
     * 
     * @param 拉取已授权的帐号信息Request
     * 
     */
    拉取已授权的帐号信息Response 拉取已授权的帐号信息(拉取已授权的帐号信息Request 拉取已授权的帐号信息Request);

    /**
     * description: 该 API 用于获取授权方的基本信息，包括头像、昵称、帐号类型、认证类型、原始ID等信息。使用过程中如遇到问题，可在,发帖交流,注意： 公众号和小程序的接口返回结果不一样。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//doc/oplatform/openApi/OpenApiDoc/authorization-management/getAuthorizerInfo.html
     * api: https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_info?access_token=ACCESS_TOKEN
     * 
     * @param 获取授权帐号详情Request
     * 
     */
    获取授权帐号详情Response 获取授权帐号详情(获取授权帐号详情Request 获取授权帐号详情Request);

    /**
     * description: 本 API 用于设置授权方的公众号/小程序的选项信息，如：地理位置上报，语音识别开关，多客服开关。使用过程中如遇到问题，可在,发帖交流,注意： 设置各项选项设置信息，需要有授权方的授权，详见权限集说明。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//doc/oplatform/openApi/OpenApiDoc/authorization-management/setAuthorizerOptionInfo.html
     * api: https://api.weixin.qq.com/cgi-bin/component/set_authorizer_option?access_token=ACCESS_TOKEN
     * 
     * @param 设置授权方选项信息Request
     * 
     */
    设置授权方选项信息Response 设置授权方选项信息(设置授权方选项信息Request 设置授权方选项信息Request);

    /**
     * description: 本 API 用于获取授权方的公众号/小程序的选项设置信息，如：地理位置上报，语音识别开关，多客服开关。使用过程中如遇到问题，可在,发帖交流
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//doc/oplatform/openApi/OpenApiDoc/authorization-management/getAuthorizerOptionInfo.html
     * api: https://api.weixin.qq.com/cgi-bin/component/get_authorizer_option?access_token=ACCESS_TOKEN
     * 
     * @param 获取授权方选项信息Request
     * 
     */
    获取授权方选项信息Response 获取授权方选项信息(获取授权方选项信息Request 获取授权方选项信息Request);
}