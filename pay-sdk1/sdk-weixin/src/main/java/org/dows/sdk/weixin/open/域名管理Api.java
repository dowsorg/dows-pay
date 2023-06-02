package org.dows.sdk.weixin.open;

/**
 * @description 
 * @author lait.zhang@gmail.com
 * @date  2023年6月2日 下午2:52:10
 */
public interface 域名管理Api{

    /**
     * description: 每月只可修改申请50次
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//doc/oplatform/openApi/OpenApiDoc/thirdparty-management/domain-mgnt/modifyThirdpartyServerDomain.html
     * api: https://api.weixin.qq.com/cgi-bin/component/modify_wxa_server_domain?access_token=ACCESS_TOKEN
     * 
     * @param 设置第三方平台服务器域名Request
     * 
     */
    设置第三方平台服务器域名Response 设置第三方平台服务器域名(设置第三方平台服务器域名Request 设置第三方平台服务器域名Request);

    /**
     * description: 
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//doc/oplatform/openApi/OpenApiDoc/thirdparty-management/domain-mgnt/getThirdpartyJumpDomainConfirmFile.html
     * api: https://api.weixin.qq.com/cgi-bin/component/get_domain_confirmfile?access_token=ACCESS_TOKEN
     * 
     * @param 获取第三方平台业务域名校验文件Request
     * 
     */
    获取第三方平台业务域名校验文件Response 获取第三方平台业务域名校验文件(获取第三方平台业务域名校验文件Request 获取第三方平台业务域名校验文件Request);

    /**
     * description: 
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//doc/oplatform/openApi/OpenApiDoc/thirdparty-management/domain-mgnt/modifyThirdpartyJumpDomain.html
     * api: https://api.weixin.qq.com/cgi-bin/component/modify_wxa_jump_domain?access_token=ACCESS_TOKEN
     * 
     * @param 设置第三方平台业务域名Request
     * 
     */
    设置第三方平台业务域名Response 设置第三方平台业务域名(设置第三方平台业务域名Request 设置第三方平台业务域名Request);
}