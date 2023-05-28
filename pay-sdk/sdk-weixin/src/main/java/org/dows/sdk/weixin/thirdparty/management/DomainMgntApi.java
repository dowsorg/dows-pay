package org.dows.sdk.weixin.thirdparty.management;

/**
 * @author lait.zhang@gmail.com
 * @description domainMgntApi
 */
public interface DomainMgntApi{

    /**
     * 每月只可修改申请50次
     * https://api.weixin.qq.com/cgi-bin/component/modify_wxa_server_domain?access_token=ACCESS_TOKEN
     * 
     * @param modifyThirdpartyServerDomainRequest
     * 
     */
    ModifyThirdpartyServerDomainResponse modifyThirdpartyServerDomain(ModifyThirdpartyServerDomainRequest modifyThirdpartyServerDomainRequest);

    /**
     * 
     * https://api.weixin.qq.com/cgi-bin/component/get_domain_confirmfile?access_token=ACCESS_TOKEN
     * 
     * @param getThirdpartyJumpDomainConfirmFileRequest
     * 
     */
    GetThirdpartyJumpDomainConfirmFileResponse getThirdpartyJumpDomainConfirmFile(GetThirdpartyJumpDomainConfirmFileRequest getThirdpartyJumpDomainConfirmFileRequest);

    /**
     * 
     * https://api.weixin.qq.com/cgi-bin/component/modify_wxa_jump_domain?access_token=ACCESS_TOKEN
     * 
     * @param modifyThirdpartyJumpDomainRequest
     * 
     */
    ModifyThirdpartyJumpDomainResponse modifyThirdpartyJumpDomain(ModifyThirdpartyJumpDomainRequest modifyThirdpartyJumpDomainRequest);
}