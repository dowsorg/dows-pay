package org.dows.sdk.weixin.open.dsfptgl;

import org.dows.sdk.weixin.open.dsfptgl.request.HuoQuDiSanFangPingTaiYeWuYuMingXiaoYanWenJianRequest;
import org.dows.sdk.weixin.open.dsfptgl.request.SheZhiDiSanFangPingTaiFuWuQiYuMingRequest;
import org.dows.sdk.weixin.open.dsfptgl.request.SheZhiDiSanFangPingTaiYeWuYuMingRequest;
import org.dows.sdk.weixin.open.dsfptgl.response.HuoQuDiSanFangPingTaiYeWuYuMingXiaoYanWenJianResponse;
import org.dows.sdk.weixin.open.dsfptgl.response.SheZhiDiSanFangPingTaiFuWuQiYuMingResponse;
import org.dows.sdk.weixin.open.dsfptgl.response.SheZhiDiSanFangPingTaiYeWuYuMingResponse;

/**
 * 域名管理
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface YuMingGuanLiApi {

    /**
     * 设置第三方平台服务器域名
     * descr: 每月只可修改申请50次
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/thirdparty-management/domain-mgnt/modifyThirdpartyServerDomain.html
     * api: https://api.weixin.qq.com/cgi-bin/component/modify_wxa_server_domain?access_token=ACCESS_TOKEN
     *
     * @param sheZhiDiSanFangPingTaiFuWuQiYuMingRequest
     */
    SheZhiDiSanFangPingTaiFuWuQiYuMingResponse sheZhiDiSanFangPingTaiFuWuQiYuMing(SheZhiDiSanFangPingTaiFuWuQiYuMingRequest sheZhiDiSanFangPingTaiFuWuQiYuMingRequest);

    /**
     * 获取第三方平台业务域名校验文件
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/thirdparty-management/domain-mgnt/getThirdpartyJumpDomainConfirmFile.html
     * api: https://api.weixin.qq.com/cgi-bin/component/get_domain_confirmfile?access_token=ACCESS_TOKEN
     *
     * @param huoQuDiSanFangPingTaiYeWuYuMingXiaoYanWenJianRequest
     */
    HuoQuDiSanFangPingTaiYeWuYuMingXiaoYanWenJianResponse huoQuDiSanFangPingTaiYeWuYuMingXiaoYanWenJian(HuoQuDiSanFangPingTaiYeWuYuMingXiaoYanWenJianRequest huoQuDiSanFangPingTaiYeWuYuMingXiaoYanWenJianRequest);

    /**
     * 设置第三方平台业务域名
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/thirdparty-management/domain-mgnt/modifyThirdpartyJumpDomain.html
     * api: https://api.weixin.qq.com/cgi-bin/component/modify_wxa_jump_domain?access_token=ACCESS_TOKEN
     *
     * @param sheZhiDiSanFangPingTaiYeWuYuMingRequest
     */
    SheZhiDiSanFangPingTaiYeWuYuMingResponse sheZhiDiSanFangPingTaiYeWuYuMing(SheZhiDiSanFangPingTaiYeWuYuMingRequest sheZhiDiSanFangPingTaiYeWuYuMingRequest);
}