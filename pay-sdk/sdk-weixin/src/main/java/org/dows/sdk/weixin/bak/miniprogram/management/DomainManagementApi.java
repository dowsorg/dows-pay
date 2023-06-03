package org.dows.sdk.weixin.bak.miniprogram.management;

import org.dows.sdk.weixin.bak.miniprogram.management.request.*;
import org.dows.sdk.weixin.bak.miniprogram.management.response.*;

/**
 * @author lait.zhang@gmail.com
 * @description domainManagementApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface DomainManagementApi {

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/domain-management/modifyServerDomain.html
     * api: https://api.weixin.qq.com/wxa/modify_domain?access_token=ACCESS_TOKEN
     *
     * @param modifyServerDomainRequest
     */
    ModifyServerDomainResponse modifyServerDomain(ModifyServerDomainRequest modifyServerDomainRequest);

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/domain-management/modifyJumpDomain.html
     * api: https://api.weixin.qq.com/wxa/setwebviewdomain?access_token=ACCESS_TOKEN
     *
     * @param modifyJumpDomainRequest
     */
    ModifyJumpDomainResponse modifyJumpDomain(ModifyJumpDomainRequest modifyJumpDomainRequest);

    /**
     * description: 1、由于一个小程序帐号的域名可以通过公众平台配置、可以通过接口配置，也可以通过改接口进行配置；但如果是通过接口配置的域名会在发布环节做一些处理2、因此，为了方便开发者更好理解不同渠道配置的域名最后生效的效果是如何的，可通过接口获取“effective_domaian”信息，确保无误之后再进行代码发布操作。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/domain-management/modifyServerDomainDirectly.html
     * api: https://api.weixin.qq.com/wxa/modify_domain_directly?access_token=ACCESS_TOKEN
     *
     * @param modifyServerDomainDirectlyRequest
     */
    ModifyServerDomainDirectlyResponse modifyServerDomainDirectly(ModifyServerDomainDirectlyRequest modifyServerDomainDirectlyRequest);

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/domain-management/getJumpDomainConfirmFile.html
     * api: https://api.weixin.qq.com/wxa/get_webviewdomain_confirmfile?access_token=ACCESS_TOKEN
     *
     * @param getJumpDomainConfirmFileRequest
     */
    GetJumpDomainConfirmFileResponse getJumpDomainConfirmFile(GetJumpDomainConfirmFileRequest getJumpDomainConfirmFileRequest);

    /**
     * description: 1、由于一个小程序帐号的域名可以通过公众平台配置、可以通过接口配置，也可以通过改接口进行配置；但如果是通过接口配置的域名会在发布环节做一些处理2、因此，为了方便开发者更好理解不同渠道配置的域名最后生效的效果是如何的，可通过接口获取“effective_webviewdomain”信息，确保无误之后再进行代码发布操作。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/domain-management/modifyJumpDomainDirectly.html
     * api: https://api.weixin.qq.com/wxa/setwebviewdomain_directly?access_token=ACCESS_TOKEN
     *
     * @param modifyJumpDomainDirectlyRequest
     */
    ModifyJumpDomainDirectlyResponse modifyJumpDomainDirectly(ModifyJumpDomainDirectlyRequest modifyJumpDomainDirectlyRequest);

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/domain-management/getEffectiveServerDomain.html
     * api: https://api.weixin.qq.com/wxa/get_effective_domain?access_token=ACCESS_TOKEN
     *
     * @param getEffectiveServerDomainRequest
     */
    GetEffectiveServerDomainResponse getEffectiveServerDomain(GetEffectiveServerDomainRequest getEffectiveServerDomainRequest);

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/domain-management/getEffectiveJumpDomain.html
     * api: https://api.weixin.qq.com/wxa/get_effective_webviewdomain?access_token=ACCESS_TOKEN
     *
     * @param getEffectiveJumpDomainRequest
     */
    GetEffectiveJumpDomainResponse getEffectiveJumpDomain(GetEffectiveJumpDomainRequest getEffectiveJumpDomainRequest);

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/domain-management/getPrefetchDomain.html
     * api: https://api.weixin.qq.com/wxa/get_prefetchdnsdomain?access_token=ACCESS_TOKEN
     *
     * @param getPrefetchDomainRequest
     */
    GetPrefetchDomainResponse getPrefetchDomain(GetPrefetchDomainRequest getPrefetchDomainRequest);

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/domain-management/setPrefetchDomain.html
     * api: https://api.weixin.qq.com/wxa/set_prefetchdnsdomain?access_token=ACCESS_TOKEN
     *
     * @param setPrefetchDomainRequest
     */
    SetPrefetchDomainResponse setPrefetchDomain(SetPrefetchDomainRequest setPrefetchDomainRequest);
}