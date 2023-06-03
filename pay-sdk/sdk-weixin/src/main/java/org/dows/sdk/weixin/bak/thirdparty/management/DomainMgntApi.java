package org.dows.sdk.weixin.bak.thirdparty.management;

import org.dows.sdk.weixin.bak.thirdparty.management.request.GetThirdpartyJumpDomainConfirmFileRequest;
import org.dows.sdk.weixin.bak.thirdparty.management.request.ModifyThirdpartyJumpDomainRequest;
import org.dows.sdk.weixin.bak.thirdparty.management.request.ModifyThirdpartyServerDomainRequest;
import org.dows.sdk.weixin.bak.thirdparty.management.response.GetThirdpartyJumpDomainConfirmFileResponse;
import org.dows.sdk.weixin.bak.thirdparty.management.response.ModifyThirdpartyJumpDomainResponse;
import org.dows.sdk.weixin.bak.thirdparty.management.response.ModifyThirdpartyServerDomainResponse;

/**
 * @author lait.zhang@gmail.com
 * @description domainMgntApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface DomainMgntApi {

    /**
     * description: 每月只可修改申请50次
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/thirdparty-management/domain-mgnt/modifyThirdpartyServerDomain.html
     * api: https://api.weixin.qq.com/cgi-bin/component/modify_wxa_server_domain?access_token=ACCESS_TOKEN
     *
     * @param modifyThirdpartyServerDomainRequest
     */
    ModifyThirdpartyServerDomainResponse modifyThirdpartyServerDomain(ModifyThirdpartyServerDomainRequest modifyThirdpartyServerDomainRequest);

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/thirdparty-management/domain-mgnt/getThirdpartyJumpDomainConfirmFile.html
     * api: https://api.weixin.qq.com/cgi-bin/component/get_domain_confirmfile?access_token=ACCESS_TOKEN
     *
     * @param getThirdpartyJumpDomainConfirmFileRequest
     */
    GetThirdpartyJumpDomainConfirmFileResponse getThirdpartyJumpDomainConfirmFile(GetThirdpartyJumpDomainConfirmFileRequest getThirdpartyJumpDomainConfirmFileRequest);

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/thirdparty-management/domain-mgnt/modifyThirdpartyJumpDomain.html
     * api: https://api.weixin.qq.com/cgi-bin/component/modify_wxa_jump_domain?access_token=ACCESS_TOKEN
     *
     * @param modifyThirdpartyJumpDomainRequest
     */
    ModifyThirdpartyJumpDomainResponse modifyThirdpartyJumpDomain(ModifyThirdpartyJumpDomainRequest modifyThirdpartyJumpDomainRequest);
}