package org.dows.sdk.weixin.open.openapigl;

import org.dows.sdk.weixin.open.openapigl.request.ChaXunAPIDiaoYongEDuRequest;
import org.dows.sdk.weixin.open.openapigl.request.ChaXunridXinXiRequest;
import org.dows.sdk.weixin.open.openapigl.request.ShiYongAppSecretZhongZhiDiSanFangPingTaiAPIDiaoYongCiShuRequest;
import org.dows.sdk.weixin.open.openapigl.request.ZhongZhiAPIDiaoYongCiShuRequest;
import org.dows.sdk.weixin.open.openapigl.response.ChaXunAPIDiaoYongEDuResponse;
import org.dows.sdk.weixin.open.openapigl.response.ChaXunridXinXiResponse;
import org.dows.sdk.weixin.open.openapigl.response.ShiYongAppSecretZhongZhiDiSanFangPingTaiAPIDiaoYongCiShuResponse;
import org.dows.sdk.weixin.open.openapigl.response.ZhongZhiAPIDiaoYongCiShuResponse;

/**
 * openApi管理
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface OpenApiGuanLiApi {

    /**
     * 重置API调用次数
     * descr: 本接口用于清空公众号/小程序/第三方平台等接口的每日调用接口次数,1、如果要清空公众号的接口的quota，则需要用公众号的access_token；如果要清空小程序的接口的quota，则需要用,；如果要清空第三方平台的接口的quota，则需要用,2、如果是第三方服务商代公众号或者小程序清除quota，则需要用,3、每个帐号每月共10次清零操作机会，清零生效一次即用掉一次机会；第三方帮助公众号/小程序调用时，实际上是在消耗公众号/小程序自身的quota,4、由于指标计算方法或统计时间差异，实时调用量数据可能会出现误差，一般在1%以内
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/openapi/clearQuota.html
     * api: https://api.weixin.qq.com/cgi-bin/clear_quota?access_token=ACCESS_TOKEN
     *
     * @param zhongZhiAPIDiaoYongCiShuRequest
     */
    ZhongZhiAPIDiaoYongCiShuResponse zhongZhiAPIDiaoYongCiShu(ZhongZhiAPIDiaoYongCiShuRequest zhongZhiAPIDiaoYongCiShuRequest);

    /**
     * 查询API调用额度
     * descr: 本接口用于查询公众号/小程序/第三方平台等接口的每日调用接口的额度以及调用次数,1、如果查询的api属于公众号的接口，则需要用,；如果查询的api属于小程序的接口，则需要用,；如果查询的接口属于第三方平台的接口，则需要用,2、如果是第三方服务商代公众号或者小程序查询公众号或者小程序的api，则需要用,3、每个接口都有调用次数限制，请开发者合理调用接口,4、”/xxx/sns/xxx“这类接口不支持使用该接口，会出现76022报错。,5、如果业务api定义了业务上的quota，那么以业务api的quota为准
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/openapi/getApiQuota.html
     * api: https://api.weixin.qq.com/cgi-bin/openapi/quota/get?access_token=ACCESS_TOKEN
     *
     * @param chaXunAPIDiaoYongEDuRequest
     */
    ChaXunAPIDiaoYongEDuResponse chaXunAPIDiaoYongEDu(ChaXunAPIDiaoYongEDuRequest chaXunAPIDiaoYongEDuRequest);

    /**
     * 查询rid信息
     * descr: 本接口用于查询调用公众号/小程序/第三方平台等接口报错返回的rid详情信息，辅助开发者高效定位问题。,1、由于查询rid信息属于开发者私密行为，因此仅支持同账号的查询。举个例子，rid=1111，是小程序账号A调用某接口出现的报错，那么则需要使用小程序账号A的access_token调用当前接口查询rid=1111的详情信息，如果使用小程序账号B的身份查询，则出现报错，错误码为xxx。公众号、第三方平台账号的接口同理。,2、如果是第三方服务商代公众号或者小程序查询公众号或者小程序的api返回的rid，则使用同一账号的,调用即可,3、rid的有效期只有7天，即只可查询最近7天的rid，查询超过7天的rid会出现报错，错误码为76001,4、”/xxx/sns/xxx“这类接口不支持使用该接口，会出现76022报错。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/openapi/getRidInfo.html
     * api: https://api.weixin.qq.com/cgi-bin/openapi/rid/get?access_token=ACCESS_TOKEN
     *
     * @param chaXunridXinXiRequest
     */
    ChaXunridXinXiResponse chaXunridXinXi(ChaXunridXinXiRequest chaXunridXinXiRequest);

    /**
     * 使用AppSecret重置第三方平台 API 调用次数
     * descr: 本接口用于清空公众号/小程序/第三方等接口的每日调用接口次数,1、该接口通过appsecret调用，解决了accesss_token耗尽无法调用,的情况,2、每个帐号每月使用,与本接口共10次清零操作机会，清零生效一次即用掉一次机会；,3、由于指标计算方法或统计时间差异，实时调用量数据可能会出现误差，一般在1%以内,4、该接口仅支持POST调用,5、该接口可以代公众号/小程序用户重置接口调用次数，appid参数需要是已授权的账号。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/openapi/clearComponentQuotaByAppSecret.html
     * api: https://api.weixin.qq.com/cgi-bin/component/clear_quota/v2
     *
     * @param shiYongAppSecretZhongZhiDiSanFangPingTaiAPIDiaoYongCiShuRequest
     */
    ShiYongAppSecretZhongZhiDiSanFangPingTaiAPIDiaoYongCiShuResponse shiYongAppSecretZhongZhiDiSanFangPingTaiAPIDiaoYongCiShu(ShiYongAppSecretZhongZhiDiSanFangPingTaiAPIDiaoYongCiShuRequest shiYongAppSecretZhongZhiDiSanFangPingTaiAPIDiaoYongCiShuRequest);
}