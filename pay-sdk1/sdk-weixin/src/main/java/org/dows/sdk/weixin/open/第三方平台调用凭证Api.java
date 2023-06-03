package org.dows.sdk.weixin.open1;

/**
 * @description 
 * @author lait.zhang@gmail.com
 * @date  2023年6月2日 下午2:52:10
 */
public interface 第三方平台调用凭证Api{

    /**
     * description: 该 API 用于启动ticket推送服务。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//doc/oplatform/openApi/OpenApiDoc/ticket-token/startPushTicket.html
     * api: https://api.weixin.qq.com/cgi-bin/component/api_start_push_ticket
     * 
     * @param 启动票据推送服务Request
     * 
     */
    启动票据推送服务Response 启动票据推送服务(启动票据推送服务Request 启动票据推送服务Request);

    /**
     * description: 该接口用于获取预授权码（pre_auth_code）是第三方平台方实现授权托管的必备信息，每个预授权码有效期为 1800秒。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//doc/oplatform/openApi/OpenApiDoc/ticket-token/getPreAuthCode.html
     * api: https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?access_token=ACCESS_TOKEN
     * 
     * @param 获取预授权码Request
     * 
     */
    获取预授权码Response 获取预授权码(获取预授权码Request 获取预授权码Request);

    /**
     * description: 该接口用于获取授权帐号的authorizer_access_token。authorizer_access_token 有效期为 2 小时，authorizer_access_token 失效时，可以使用 authorizer_refresh_token 获取新的 authorizer_access_token。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//doc/oplatform/openApi/OpenApiDoc/ticket-token/getAuthorizerAccessToken.html
     * api: https://api.weixin.qq.com/cgi-bin/component/api_authorizer_token?component_access_token=ACCESS_TOKEN
     * 
     * @param 获取授权帐号调用令牌Request
     * 
     */
    获取授权帐号调用令牌Response 获取授权帐号调用令牌(获取授权帐号调用令牌Request 获取授权帐号调用令牌Request);

    /**
     * description: 
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//doc/oplatform/openApi/OpenApiDoc/ticket-token/getAuthorizerRefreshToken.html
     * api: https://api.weixin.qq.com/cgi-bin/component/api_query_auth?access_token=ACCESS_TOKEN
     * 
     * @param 获取刷新令牌Request
     * 
     */
    获取刷新令牌Response 获取刷新令牌(获取刷新令牌Request 获取刷新令牌Request);

    /**
     * description: 令牌（component_access_token）是第三方平台接口的调用凭据
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//doc/oplatform/openApi/OpenApiDoc/ticket-token/getComponentAccessToken.html
     * api: https://api.weixin.qq.com/cgi-bin/component/api_component_token
     * 
     * @param 获取令牌Request
     * 
     */
    获取令牌Response 获取令牌(获取令牌Request 获取令牌Request);
}