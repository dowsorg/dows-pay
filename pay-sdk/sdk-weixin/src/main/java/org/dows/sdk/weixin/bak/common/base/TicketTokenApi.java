package org.dows.sdk.weixin.bak.common.base;

import org.dows.sdk.weixin.bak.common.base.request.*;
import org.dows.sdk.weixin.bak.common.base.response.*;

/**
 * @author lait.zhang@gmail.com
 * @description ticketTokenApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface TicketTokenApi {

    /**
     * description: 该 API 用于启动ticket推送服务。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ticket-token/startPushTicket.html
     * api: https://api.weixin.qq.com/cgi-bin/component/api_start_push_ticket
     *
     * @param startPushTicketRequest
     */
    StartPushTicketResponse startPushTicket(StartPushTicketRequest startPushTicketRequest);

    /**
     * description: 该接口用于获取预授权码（pre_auth_code）是第三方平台方实现授权托管的必备信息，每个预授权码有效期为 1800秒。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ticket-token/getPreAuthCode.html
     * api: https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?access_token=ACCESS_TOKEN
     *
     * @param getPreAuthCodeRequest
     */
    GetPreAuthCodeResponse getPreAuthCode(GetPreAuthCodeRequest getPreAuthCodeRequest);

    /**
     * description: 该接口用于获取授权帐号的authorizer_access_token。authorizer_access_token 有效期为 2 小时，authorizer_access_token 失效时，可以使用 authorizer_refresh_token 获取新的 authorizer_access_token。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ticket-token/getAuthorizerAccessToken.html
     * api: https://api.weixin.qq.com/cgi-bin/component/api_authorizer_token?component_access_token=ACCESS_TOKEN
     *
     * @param getAuthorizerAccessTokenRequest
     */
    GetAuthorizerAccessTokenResponse getAuthorizerAccessToken(GetAuthorizerAccessTokenRequest getAuthorizerAccessTokenRequest);

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ticket-token/getAuthorizerRefreshToken.html
     * api: https://api.weixin.qq.com/cgi-bin/component/api_query_auth?access_token=ACCESS_TOKEN
     *
     * @param getAuthorizerRefreshTokenRequest
     */
    GetAuthorizerRefreshTokenResponse getAuthorizerRefreshToken(GetAuthorizerRefreshTokenRequest getAuthorizerRefreshTokenRequest);

    /**
     * description: 令牌（component_access_token）是第三方平台接口的调用凭据
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ticket-token/getComponentAccessToken.html
     * api: https://api.weixin.qq.com/cgi-bin/component/api_component_token
     *
     * @param getComponentAccessTokenRequest
     */
    GetComponentAccessTokenResponse getComponentAccessToken(GetComponentAccessTokenRequest getComponentAccessTokenRequest);
}