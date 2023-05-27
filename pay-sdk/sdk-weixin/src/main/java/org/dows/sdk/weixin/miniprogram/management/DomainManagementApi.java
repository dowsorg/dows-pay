package org.dows.sdk.weixin.miniprogram.management;

import org.dows.sdk.weixin.miniprogram.management.request.*;
import org.dows.sdk.weixin.miniprogram.management.response.*;

/**
 * @author
 * @description 调用方式以及出入参和HTTPS相同，仅是调用的token不同该接口所属的权限集id为：18服务商获得其中之一权限集授权后，可通过使用代商家进行调用
 * @date
 */
public interface DomainManagementApi {
    /**
     * @param modifyServerDomainRequest
     */
    ModifyServerDomainResponse modifyServerDomain(ModifyServerDomainRequest modifyServerDomainRequest);

    /**
     * @param modifyJumpDomainRequest
     */
    ModifyJumpDomainResponse modifyJumpDomain(ModifyJumpDomainRequest modifyJumpDomainRequest);

    /**
     * 1、由于一个小程序帐号的域名可以通过公众平台配置、可以通过接口配置，也可以通过改接口进行配置；但如果是通过接口配置的域名会在发布环节做一些处理2、因此，为了方便开发者更好理解不同渠道配置的域名最后生效的效果是如何的，可通过接口获取“effective_domaian”信息，确保无误之后再进行代码发布操作。
     *
     * @param modifyServerDomainDirectlyRequest
     */
    ModifyServerDomainDirectlyResponse modifyServerDomainDirectly(ModifyServerDomainDirectlyRequest modifyServerDomainDirectlyRequest);

    /**
     * @param getJumpDomainConfirmFileRequest
     */
    GetJumpDomainConfirmFileResponse getJumpDomainConfirmFile(GetJumpDomainConfirmFileRequest getJumpDomainConfirmFileRequest);

    /**
     * 1、由于一个小程序帐号的域名可以通过公众平台配置、可以通过接口配置，也可以通过改接口进行配置；但如果是通过接口配置的域名会在发布环节做一些处理2、因此，为了方便开发者更好理解不同渠道配置的域名最后生效的效果是如何的，可通过接口获取“effective_webviewdomain”信息，确保无误之后再进行代码发布操作。
     *
     * @param modifyJumpDomainDirectlyRequest
     */
    ModifyJumpDomainDirectlyResponse modifyJumpDomainDirectly(ModifyJumpDomainDirectlyRequest modifyJumpDomainDirectlyRequest);

    /**
     * @param getEffectiveServerDomainRequest
     */
    GetEffectiveServerDomainResponse getEffectiveServerDomain(GetEffectiveServerDomainRequest getEffectiveServerDomainRequest);

    /**
     * @param getEffectiveJumpDomainRequest
     */
    GetEffectiveJumpDomainResponse getEffectiveJumpDomain(GetEffectiveJumpDomainRequest getEffectiveJumpDomainRequest);

    /**
     * @param getPrefetchDomainRequest
     */
    GetPrefetchDomainResponse getPrefetchDomain(GetPrefetchDomainRequest getPrefetchDomainRequest);

    /**
     * @param setPrefetchDomainRequest
     */
    SetPrefetchDomainResponse setPrefetchDomain(SetPrefetchDomainRequest setPrefetchDomainRequest);

}
