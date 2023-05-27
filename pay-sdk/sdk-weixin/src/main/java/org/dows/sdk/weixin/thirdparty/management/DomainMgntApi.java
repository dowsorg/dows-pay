package org.dows.sdk.weixin.thirdparty.management;

import org.dows.sdk.weixin.thirdparty.management.request.GetThirdpartyJumpDomainConfirmFileRequest;
import org.dows.sdk.weixin.thirdparty.management.request.ModifyThirdpartyJumpDomainRequest;
import org.dows.sdk.weixin.thirdparty.management.request.ModifyThirdpartyServerDomainRequest;
import org.dows.sdk.weixin.thirdparty.management.response.GetThirdpartyJumpDomainConfirmFileResponse;
import org.dows.sdk.weixin.thirdparty.management.response.ModifyThirdpartyJumpDomainResponse;
import org.dows.sdk.weixin.thirdparty.management.response.ModifyThirdpartyServerDomainResponse;

/**
 * @author
 * @description
 * @date
 */
public interface DomainMgntApi {
    /**
     * 每月只可修改申请50次
     *
     * @param modifyThirdpartyServerDomainRequest
     */
    ModifyThirdpartyServerDomainResponse modifyThirdpartyServerDomain(ModifyThirdpartyServerDomainRequest modifyThirdpartyServerDomainRequest);

    /**
     * @param getThirdpartyJumpDomainConfirmFileRequest
     */
    GetThirdpartyJumpDomainConfirmFileResponse getThirdpartyJumpDomainConfirmFile(GetThirdpartyJumpDomainConfirmFileRequest getThirdpartyJumpDomainConfirmFileRequest);

    /**
     * @param modifyThirdpartyJumpDomainRequest
     */
    ModifyThirdpartyJumpDomainResponse modifyThirdpartyJumpDomain(ModifyThirdpartyJumpDomainRequest modifyThirdpartyJumpDomainRequest);


}
