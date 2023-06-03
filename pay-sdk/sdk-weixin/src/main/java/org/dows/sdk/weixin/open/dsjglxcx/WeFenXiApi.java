package org.dows.sdk.weixin.open.dsjglxcx;

import org.dows.sdk.weixin.open.dsjglxcx.request.*;
import org.dows.sdk.weixin.open.dsjglxcx.response.*;

/**
 * We分析
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface WeFenXiApi {

    /**
     * 查询登陆配置
     * descr: 查询服务商登录配置
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/we-analysis/weDataGetLoginConfig.html
     * api: https://api.weixin.qq.com/wedata/wedata_get_login_config?access_token=ACCESS_TOKEN
     *
     * @param chaXunDengLuPeiZhiRequest
     */
    ChaXunDengLuPeiZhiResponse chaXunDengLuPeiZhi(ChaXunDengLuPeiZhiRequest chaXunDengLuPeiZhiRequest);

    /**
     * 设置登录配置
     * descr: 设置服务商登录配置,登录配置分为PC端和小程序端，根据接入方式不同需要配置相应的信息。,PC端登录需配置反查地址用于查询用户访问服务商系统的登录态，因此服务商需要提供反查接口，详情可见,->3.接入流程->第3步->PC端->登录态反查,：此接口由服务商自行提供，根据用户在服务商系统登录的登录态反查用户所属uid和过期时间,： ***（服务商提供http请求地址，但请求参数与返回参数需要遵循文档规定）,：POST application/json,：,：
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/we-analysis/weDataSetLoginConfig.html
     * api: https://api.weixin.qq.com/wedata/wedata_set_login_config?access_token=ACCESS_TOKEN
     *
     * @param sheZhiDengLuPeiZhiRequest
     */
    SheZhiDengLuPeiZhiResponse sheZhiDengLuPeiZhi(SheZhiDengLuPeiZhiRequest sheZhiDengLuPeiZhiRequest);

    /**
     * 获取商家We分析权限集列表
     * descr: 获取当前商家的We分析权限集列表
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/we-analysis/weDataGetPermList.html
     * api: https://api.weixin.qq.com/wedata/wedata_get_perm_list?access_token=ACCESS_TOKEN
     *
     * @param huoQuShangJiaWeFenXiQuanXianJiLieBiaoRequest
     */
    HuoQuShangJiaWeFenXiQuanXianJiLieBiaoResponse huoQuShangJiaWeFenXiQuanXianJiLieBiao(HuoQuShangJiaWeFenXiQuanXianJiLieBiaoRequest huoQuShangJiaWeFenXiQuanXianJiLieBiaoRequest);

    /**
     * 设置用户We分析权限集
     * descr: 全量设置用户权限集
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/we-analysis/weDataSetUserPerm.html
     * api: https://api.weixin.qq.com/wedata/wedata_set_user_perm?access_token=ACCESS_TOKEN
     *
     * @param sheZhiYongHuWeFenXiQuanXianJiRequest
     */
    SheZhiYongHuWeFenXiQuanXianJiResponse sheZhiYongHuWeFenXiQuanXianJi(SheZhiYongHuWeFenXiQuanXianJiRequest sheZhiYongHuWeFenXiQuanXianJiRequest);

    /**
     * 查询用户绑定列表
     * descr: 查询用户绑定列表
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/we-analysis/weDataQueryBindList.html
     * api: https://api.weixin.qq.com/wedata/wedata_query_bind_list?access_token=ACCESS_TOKEN
     *
     * @param chaXunYongHuBangDingLieBiaoRequest
     */
    ChaXunYongHuBangDingLieBiaoResponse chaXunYongHuBangDingLieBiao(ChaXunYongHuBangDingLieBiaoRequest chaXunYongHuBangDingLieBiaoRequest);

    /**
     * 用户解绑
     * descr: 用户解绑
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/we-analysis/weDataUnbindUser.html
     * api: https://api.weixin.qq.com/wedata/wedata_unbind_user?access_token=ACCESS_TOKEN
     *
     * @param yongHuJieBangRequest
     */
    YongHuJieBangResponse yongHuJieBang(YongHuJieBangRequest yongHuJieBangRequest);

    /**
     * 用户PC端登录
     * descr: 用户PC端登录,访问获取到的登录链接, 若出现100024错误码，表示此时we分析系统获取到的用户client_ip和user_agent 跟 服务商系统调用api时传入的不一致,：此接口由服务商自行提供，在调用登录接口时会根据用户在服务商系统登录的登录态反查用户所属uid和过期时间,： ***（服务商提供http请求地址，但请求参数与返回参数需要遵循文档规定）,：POST application/json,：,：
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/we-analysis/wedata_login.html
     * api: https://api.weixin.qq.com/wedata/wedata_login?access_token=ACCESS_TOKEN
     *
     * @param yongHuPCDuanDengLuRequest
     */
    YongHuPCDuanDengLuResponse yongHuPCDuanDengLu(YongHuPCDuanDengLuRequest yongHuPCDuanDengLuRequest);
}