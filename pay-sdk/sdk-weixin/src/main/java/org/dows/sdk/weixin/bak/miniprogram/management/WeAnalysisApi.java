package org.dows.sdk.weixin.bak.miniprogram.management;

import org.dows.sdk.weixin.bak.miniprogram.management.request.*;
import org.dows.sdk.weixin.bak.miniprogram.management.response.*;

/**
 * @author lait.zhang@gmail.com
 * @description weAnalysisApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface WeAnalysisApi {

    /**
     * description: 查询服务商登录配置
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/we-analysis/weDataGetLoginConfig.html
     * api: https://api.weixin.qq.com/wedata/wedata_get_login_config?access_token=ACCESS_TOKEN
     *
     * @param weDataGetLoginConfigRequest
     */
    WeDataGetLoginConfigResponse weDataGetLoginConfig(WeDataGetLoginConfigRequest weDataGetLoginConfigRequest);

    /**
     * description: 设置服务商登录配置登录配置分为PC端和小程序端，根据接入方式不同需要配置相应的信息。PC端登录需配置反查地址用于查询用户访问服务商系统的登录态，因此服务商需要提供反查接口，详情可见->3.接入流程->第3步->PC端->登录态反查：此接口由服务商自行提供，根据用户在服务商系统登录的登录态反查用户所属uid和过期时间： ***（服务商提供http请求地址，但请求参数与返回参数需要遵循文档规定）：POST application/json：：
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/we-analysis/weDataSetLoginConfig.html
     * api: https://api.weixin.qq.com/wedata/wedata_set_login_config?access_token=ACCESS_TOKEN
     *
     * @param weDataSetLoginConfigRequest
     */
    WeDataSetLoginConfigResponse weDataSetLoginConfig(WeDataSetLoginConfigRequest weDataSetLoginConfigRequest);

    /**
     * description: 获取当前商家的We分析权限集列表
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/we-analysis/weDataGetPermList.html
     * api: https://api.weixin.qq.com/wedata/wedata_get_perm_list?access_token=ACCESS_TOKEN
     *
     * @param weDataGetPermListRequest
     */
    WeDataGetPermListResponse weDataGetPermList(WeDataGetPermListRequest weDataGetPermListRequest);

    /**
     * description: 全量设置用户权限集
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/we-analysis/weDataSetUserPerm.html
     * api: https://api.weixin.qq.com/wedata/wedata_set_user_perm?access_token=ACCESS_TOKEN
     *
     * @param weDataSetUserPermRequest
     */
    WeDataSetUserPermResponse weDataSetUserPerm(WeDataSetUserPermRequest weDataSetUserPermRequest);

    /**
     * description: 查询用户绑定列表
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/we-analysis/weDataQueryBindList.html
     * api: https://api.weixin.qq.com/wedata/wedata_query_bind_list?access_token=ACCESS_TOKEN
     *
     * @param weDataQueryBindListRequest
     */
    WeDataQueryBindListResponse weDataQueryBindList(WeDataQueryBindListRequest weDataQueryBindListRequest);

    /**
     * description: 用户解绑
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/we-analysis/weDataUnbindUser.html
     * api: https://api.weixin.qq.com/wedata/wedata_unbind_user?access_token=ACCESS_TOKEN
     *
     * @param weDataUnbindUserRequest
     */
    WeDataUnbindUserResponse weDataUnbindUser(WeDataUnbindUserRequest weDataUnbindUserRequest);

    /**
     * description: 用户PC端登录访问获取到的登录链接, 若出现100024错误码，表示此时we分析系统获取到的用户client_ip和user_agent 跟 服务商系统调用api时传入的不一致：此接口由服务商自行提供，在调用登录接口时会根据用户在服务商系统登录的登录态反查用户所属uid和过期时间： ***（服务商提供http请求地址，但请求参数与返回参数需要遵循文档规定）：POST application/json：：
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/we-analysis/wedata_login.html
     * api: https://api.weixin.qq.com/wedata/wedata_login?access_token=ACCESS_TOKEN
     *
     * @param wedataLoginRequest
     */
    WedataLoginResponse wedataLogin(WedataLoginRequest wedataLoginRequest);
}