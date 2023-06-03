package org.dows.sdk.weixin.open.dsfptgl;

import org.dows.sdk.weixin.open.dsfptgl.request.BangDingKaiFangPingTaiZhangHaoRequest;
import org.dows.sdk.weixin.open.dsfptgl.request.ChuangJianKaiFangPingTaiZhangHaoRequest;
import org.dows.sdk.weixin.open.dsfptgl.request.HuoQuKaiFangPingTaiZhangHaoRequest;
import org.dows.sdk.weixin.open.dsfptgl.request.JieChuBangDingKaiFangPingTaiZhangHaoRequest;
import org.dows.sdk.weixin.open.dsfptgl.response.BangDingKaiFangPingTaiZhangHaoResponse;
import org.dows.sdk.weixin.open.dsfptgl.response.ChuangJianKaiFangPingTaiZhangHaoResponse;
import org.dows.sdk.weixin.open.dsfptgl.response.HuoQuKaiFangPingTaiZhangHaoResponse;
import org.dows.sdk.weixin.open.dsfptgl.response.JieChuBangDingKaiFangPingTaiZhangHaoResponse;

/**
 * 开放平台帐号管理
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface KaiFangPingTaiZhangHaoGuanLiApi {

    /**
     * 绑定开放平台帐号
     * descr: 1、对于未认证的open帐号，只适用于open帐号通过接口创建的，且只适用于绑定同主体的帐号，以及最多只能绑定5个,2、对于未认证的open帐号，但是是通过微信开放平台界面注册的，不可通过该接口进行绑定。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/openplatform-management/bindOpenAccount.html
     * api: https://api.weixin.qq.com/cgi-bin/open/bind?access_token=ACCESS_TOKEN
     *
     * @param bangDingKaiFangPingTaiZhangHaoRequest
     */
    BangDingKaiFangPingTaiZhangHaoResponse bangDingKaiFangPingTaiZhangHao(BangDingKaiFangPingTaiZhangHaoRequest bangDingKaiFangPingTaiZhangHaoRequest);

    /**
     * 解除绑定开放平台帐号
     * descr: 该 API 用于将一个公众号或小程序与指定开放平台帐号解绑。开发者须确认所指定帐号与当前该公众号或小程序所绑定的开放平台帐号一致。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/openplatform-management/unbindOpenAccount.html
     * api: https://api.weixin.qq.com/cgi-bin/open/unbind?access_token=ACCESS_TOKEN
     *
     * @param jieChuBangDingKaiFangPingTaiZhangHaoRequest
     */
    JieChuBangDingKaiFangPingTaiZhangHaoResponse jieChuBangDingKaiFangPingTaiZhangHao(JieChuBangDingKaiFangPingTaiZhangHaoRequest jieChuBangDingKaiFangPingTaiZhangHaoRequest);

    /**
     * 获取开放平台帐号
     * descr: 该 API 用于获取公众号或小程序所绑定的开放平台帐号。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/openplatform-management/getOpenAccount.html
     * api: https://api.weixin.qq.com/cgi-bin/open/get?access_token=ACCESS_TOKEN
     *
     * @param huoQuKaiFangPingTaiZhangHaoRequest
     */
    HuoQuKaiFangPingTaiZhangHaoResponse huoQuKaiFangPingTaiZhangHao(HuoQuKaiFangPingTaiZhangHaoRequest huoQuKaiFangPingTaiZhangHaoRequest);

    /**
     * 创建开放平台帐号
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/openplatform-management/createOpenAccount.html
     * api: https://api.weixin.qq.com/cgi-bin/open/create?access_token=ACCESS_TOKEN
     *
     * @param chuangJianKaiFangPingTaiZhangHaoRequest
     */
    ChuangJianKaiFangPingTaiZhangHaoResponse chuangJianKaiFangPingTaiZhangHao(ChuangJianKaiFangPingTaiZhangHaoRequest chuangJianKaiFangPingTaiZhangHaoRequest);
}