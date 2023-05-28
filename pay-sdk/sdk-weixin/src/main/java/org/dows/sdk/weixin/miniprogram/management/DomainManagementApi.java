package org.dows.sdk.weixin.miniprogram.management;

/**
 * @description domainManagementApi
 * @author lait.zhang@gmail.com
 * @date  2023年5月28日 下午9:55:33
 */
public interface DomainManagementApi{

    /**
     * 
     * https://api.weixin.qq.com/wxa/modify_domain?access_token=ACCESS_TOKEN
     * 
     * @param modifyServerDomainRequest
     * 
     */
    ModifyServerDomainResponse modifyServerDomain(ModifyServerDomainRequest modifyServerDomainRequest);

    /**
     * 
     * https://api.weixin.qq.com/wxa/setwebviewdomain?access_token=ACCESS_TOKEN
     * 
     * @param modifyJumpDomainRequest
     * 
     */
    ModifyJumpDomainResponse modifyJumpDomain(ModifyJumpDomainRequest modifyJumpDomainRequest);

    /**
     * 1、由于一个小程序帐号的域名可以通过公众平台配置、可以通过接口配置，也可以通过改接口进行配置；但如果是通过接口配置的域名会在发布环节做一些处理2、因此，为了方便开发者更好理解不同渠道配置的域名最后生效的效果是如何的，可通过接口获取“effective_domaian”信息，确保无误之后再进行代码发布操作。
     * https://api.weixin.qq.com/wxa/modify_domain_directly?access_token=ACCESS_TOKEN
     * 
     * @param modifyServerDomainDirectlyRequest
     * 
     */
    ModifyServerDomainDirectlyResponse modifyServerDomainDirectly(ModifyServerDomainDirectlyRequest modifyServerDomainDirectlyRequest);

    /**
     * 
     * https://api.weixin.qq.com/wxa/get_webviewdomain_confirmfile?access_token=ACCESS_TOKEN
     * 
     * @param getJumpDomainConfirmFileRequest
     * 
     */
    GetJumpDomainConfirmFileResponse getJumpDomainConfirmFile(GetJumpDomainConfirmFileRequest getJumpDomainConfirmFileRequest);

    /**
     * 1、由于一个小程序帐号的域名可以通过公众平台配置、可以通过接口配置，也可以通过改接口进行配置；但如果是通过接口配置的域名会在发布环节做一些处理2、因此，为了方便开发者更好理解不同渠道配置的域名最后生效的效果是如何的，可通过接口获取“effective_webviewdomain”信息，确保无误之后再进行代码发布操作。
     * https://api.weixin.qq.com/wxa/setwebviewdomain_directly?access_token=ACCESS_TOKEN
     * 
     * @param modifyJumpDomainDirectlyRequest
     * 
     */
    ModifyJumpDomainDirectlyResponse modifyJumpDomainDirectly(ModifyJumpDomainDirectlyRequest modifyJumpDomainDirectlyRequest);

    /**
     * 
     * https://api.weixin.qq.com/wxa/get_effective_domain?access_token=ACCESS_TOKEN
     * 
     * @param getEffectiveServerDomainRequest
     * 
     */
    GetEffectiveServerDomainResponse getEffectiveServerDomain(GetEffectiveServerDomainRequest getEffectiveServerDomainRequest);

    /**
     * 
     * https://api.weixin.qq.com/wxa/get_effective_webviewdomain?access_token=ACCESS_TOKEN
     * 
     * @param getEffectiveJumpDomainRequest
     * 
     */
    GetEffectiveJumpDomainResponse getEffectiveJumpDomain(GetEffectiveJumpDomainRequest getEffectiveJumpDomainRequest);

    /**
     * 
     * https://api.weixin.qq.com/wxa/get_prefetchdnsdomain?access_token=ACCESS_TOKEN
     * 
     * @param getPrefetchDomainRequest
     * 
     */
    GetPrefetchDomainResponse getPrefetchDomain(GetPrefetchDomainRequest getPrefetchDomainRequest);

    /**
     * 
     * https://api.weixin.qq.com/wxa/set_prefetchdnsdomain?access_token=ACCESS_TOKEN
     * 
     * @param setPrefetchDomainRequest
     * 
     */
    SetPrefetchDomainResponse setPrefetchDomain(SetPrefetchDomainRequest setPrefetchDomainRequest);
}