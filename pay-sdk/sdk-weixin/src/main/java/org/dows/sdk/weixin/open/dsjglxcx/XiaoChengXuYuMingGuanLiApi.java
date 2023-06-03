package org.dows.sdk.weixin.open.dsjglxcx;

import org.dows.sdk.weixin.open.dsjglxcx.request.*;
import org.dows.sdk.weixin.open.dsjglxcx.response.*;

/**
 * 小程序域名管理
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface XiaoChengXuYuMingGuanLiApi {

    /**
     * 配置小程序服务器域名
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/domain-management/modifyServerDomain.html
     * api: https://api.weixin.qq.com/wxa/modify_domain?access_token=ACCESS_TOKEN
     *
     * @param peiZhiXiaoChengXuFuWuQiYuMingRequest
     */
    PeiZhiXiaoChengXuFuWuQiYuMingResponse peiZhiXiaoChengXuFuWuQiYuMing(PeiZhiXiaoChengXuFuWuQiYuMingRequest peiZhiXiaoChengXuFuWuQiYuMingRequest);

    /**
     * 配置小程序业务域名
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/domain-management/modifyJumpDomain.html
     * api: https://api.weixin.qq.com/wxa/setwebviewdomain?access_token=ACCESS_TOKEN
     *
     * @param peiZhiXiaoChengXuYeWuYuMingRequest
     */
    PeiZhiXiaoChengXuYeWuYuMingResponse peiZhiXiaoChengXuYeWuYuMing(PeiZhiXiaoChengXuYeWuYuMingRequest peiZhiXiaoChengXuYeWuYuMingRequest);

    /**
     * 快速配置小程序服务器域名
     * descr: 1、由于一个小程序帐号的域名可以通过公众平台配置、可以通过,接口配置，也可以通过改接口进行配置；但如果是通过,接口配置的域名会在发布环节做一些处理,2、因此，为了方便开发者更好理解不同渠道配置的域名最后生效的效果是如何的，可通过,接口获取“effective_domaian”信息，确保无误之后再进行代码发布操作。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/domain-management/modifyServerDomainDirectly.html
     * api: https://api.weixin.qq.com/wxa/modify_domain_directly?access_token=ACCESS_TOKEN
     *
     * @param kuaiSuPeiZhiXiaoChengXuFuWuQiYuMingRequest
     */
    KuaiSuPeiZhiXiaoChengXuFuWuQiYuMingResponse kuaiSuPeiZhiXiaoChengXuFuWuQiYuMing(KuaiSuPeiZhiXiaoChengXuFuWuQiYuMingRequest kuaiSuPeiZhiXiaoChengXuFuWuQiYuMingRequest);

    /**
     * 获取业务域名校验文件
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/domain-management/getJumpDomainConfirmFile.html
     * api: https://api.weixin.qq.com/wxa/get_webviewdomain_confirmfile?access_token=ACCESS_TOKEN
     *
     * @param huoQuYeWuYuMingXiaoYanWenJianRequest
     */
    HuoQuYeWuYuMingXiaoYanWenJianResponse huoQuYeWuYuMingXiaoYanWenJian(HuoQuYeWuYuMingXiaoYanWenJianRequest huoQuYeWuYuMingXiaoYanWenJianRequest);

    /**
     * 快速配置小程序业务域名
     * descr: 1、由于一个小程序帐号的域名可以通过公众平台配置、可以通过,接口配置，也可以通过改接口进行配置；但如果是通过,接口配置的域名会在发布环节做一些处理,2、因此，为了方便开发者更好理解不同渠道配置的域名最后生效的效果是如何的，可通过,接口获取“effective_webviewdomain”信息，确保无误之后再进行代码发布操作。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/domain-management/modifyJumpDomainDirectly.html
     * api: https://api.weixin.qq.com/wxa/setwebviewdomain_directly?access_token=ACCESS_TOKEN
     *
     * @param kuaiSuPeiZhiXiaoChengXuYeWuYuMingRequest
     */
    KuaiSuPeiZhiXiaoChengXuYeWuYuMingResponse kuaiSuPeiZhiXiaoChengXuYeWuYuMing(KuaiSuPeiZhiXiaoChengXuYeWuYuMingRequest kuaiSuPeiZhiXiaoChengXuYeWuYuMingRequest);

    /**
     * 获取发布后生效服务器域名列表
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/domain-management/getEffectiveServerDomain.html
     * api: https://api.weixin.qq.com/wxa/get_effective_domain?access_token=ACCESS_TOKEN
     *
     * @param huoQuFaBuHouShengXiaoFuWuQiYuMingLieBiaoRequest
     */
    HuoQuFaBuHouShengXiaoFuWuQiYuMingLieBiaoResponse huoQuFaBuHouShengXiaoFuWuQiYuMingLieBiao(HuoQuFaBuHouShengXiaoFuWuQiYuMingLieBiaoRequest huoQuFaBuHouShengXiaoFuWuQiYuMingLieBiaoRequest);

    /**
     * 获取发布后生效业务域名列表
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/domain-management/getEffectiveJumpDomain.html
     * api: https://api.weixin.qq.com/wxa/get_effective_webviewdomain?access_token=ACCESS_TOKEN
     *
     * @param huoQuFaBuHouShengXiaoYeWuYuMingLieBiaoRequest
     */
    HuoQuFaBuHouShengXiaoYeWuYuMingLieBiaoResponse huoQuFaBuHouShengXiaoYeWuYuMingLieBiao(HuoQuFaBuHouShengXiaoYeWuYuMingLieBiaoRequest huoQuFaBuHouShengXiaoYeWuYuMingLieBiaoRequest);

    /**
     * 获取DNS预解析域名
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/domain-management/getPrefetchDomain.html
     * api: https://api.weixin.qq.com/wxa/get_prefetchdnsdomain?access_token=ACCESS_TOKEN
     *
     * @param huoQuDNSYuJieXiYuMingRequest
     */
    HuoQuDNSYuJieXiYuMingResponse huoQuDNSYuJieXiYuMing(HuoQuDNSYuJieXiYuMingRequest huoQuDNSYuJieXiYuMingRequest);

    /**
     * 设置DNS预解析域名
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/domain-management/setPrefetchDomain.html
     * api: https://api.weixin.qq.com/wxa/set_prefetchdnsdomain?access_token=ACCESS_TOKEN
     *
     * @param sheZhiDNSYuJieXiYuMingRequest
     */
    SheZhiDNSYuJieXiYuMingResponse sheZhiDNSYuJieXiYuMing(SheZhiDNSYuJieXiYuMingRequest sheZhiDNSYuJieXiYuMingRequest);
}