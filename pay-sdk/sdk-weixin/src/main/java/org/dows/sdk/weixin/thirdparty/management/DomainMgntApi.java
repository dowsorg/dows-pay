package org.dows.sdk.weixin.thirdparty.management;

import org.dows.sdk.weixin.thirdparty.management.request.GetThirdpartyJumpDomainConfirmFileRequest;
import org.dows.sdk.weixin.thirdparty.management.request.ModifyThirdpartyJumpDomainRequest;
import org.dows.sdk.weixin.thirdparty.management.request.ModifyThirdpartyServerDomainRequest;
import org.dows.sdk.weixin.thirdparty.management.response.GetThirdpartyJumpDomainConfirmFileResponse;
import org.dows.sdk.weixin.thirdparty.management.response.ModifyThirdpartyJumpDomainResponse;
import org.dows.sdk.weixin.thirdparty.management.response.ModifyThirdpartyServerDomainResponse;

/**
 * @author lait.zhang@gmail.com
 * @description domainMgntApi
 * @date 2023年5月28日 下午9:55:33
 */
public interface DomainMgntApi {

    /**
     * 每月只可修改申请50次
     * https://api.weixin.qq.com/cgi-bin/component/modify_wxa_server_domain?access_token=ACCESS_TOKEN
     *
     * @param modifyThirdpartyServerDomainRequest
     */
    ModifyThirdpartyServerDomainResponse modifyThirdpartyServerDomain(ModifyThirdpartyServerDomainRequest modifyThirdpartyServerDomainRequest);

    /**
     * https://api.weixin.qq.com/cgi-bin/component/get_domain_confirmfile?access_token=ACCESS_TOKEN
     *
     * @param getThirdpartyJumpDomainConfirmFileRequest
     */
    GetThirdpartyJumpDomainConfirmFileResponse getThirdpartyJumpDomainConfirmFile(GetThirdpartyJumpDomainConfirmFileRequest getThirdpartyJumpDomainConfirmFileRequest);

    /**
     * https://api.weixin.qq.com/cgi-bin/component/modify_wxa_jump_domain?access_token=ACCESS_TOKEN
     *
     * @param modifyThirdpartyJumpDomainRequest
     */
    ModifyThirdpartyJumpDomainResponse modifyThirdpartyJumpDomain(ModifyThirdpartyJumpDomainRequest modifyThirdpartyJumpDomainRequest);
}