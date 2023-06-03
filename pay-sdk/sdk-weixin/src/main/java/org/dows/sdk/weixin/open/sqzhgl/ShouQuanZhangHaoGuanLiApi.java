package org.dows.sdk.weixin.open.sqzhgl;

import org.dows.sdk.weixin.open.sqzhgl.request.HuoQuShouQuanFangXuanXiangXinXiRequest;
import org.dows.sdk.weixin.open.sqzhgl.request.HuoQuShouQuanZhangHaoXiangQingRequest;
import org.dows.sdk.weixin.open.sqzhgl.request.LaQuYiShouQuanDeZhangHaoXinXiRequest;
import org.dows.sdk.weixin.open.sqzhgl.request.SheZhiShouQuanFangXuanXiangXinXiRequest;
import org.dows.sdk.weixin.open.sqzhgl.response.HuoQuShouQuanFangXuanXiangXinXiResponse;
import org.dows.sdk.weixin.open.sqzhgl.response.HuoQuShouQuanZhangHaoXiangQingResponse;
import org.dows.sdk.weixin.open.sqzhgl.response.LaQuYiShouQuanDeZhangHaoXinXiResponse;
import org.dows.sdk.weixin.open.sqzhgl.response.SheZhiShouQuanFangXuanXiangXinXiResponse;

/**
 * 授权帐号管理
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface ShouQuanZhangHaoGuanLiApi {

    /**
     * 拉取已授权的帐号信息
     * descr: 使用本 API 拉取当前所有已授权的帐号基本信息。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/authorization-management/getAuthorizerList.html
     * api: https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_list?access_token=ACCESS_TOKEN
     *
     * @param laQuYiShouQuanDeZhangHaoXinXiRequest
     */
    LaQuYiShouQuanDeZhangHaoXinXiResponse laQuYiShouQuanDeZhangHaoXinXi(LaQuYiShouQuanDeZhangHaoXinXiRequest laQuYiShouQuanDeZhangHaoXinXiRequest);

    /**
     * 获取授权帐号详情
     * descr: 该 API 用于获取授权方的基本信息，包括头像、昵称、帐号类型、认证类型、原始ID等信息。使用过程中如遇到问题，可在,发帖交流,注意： 公众号和小程序的接口返回结果不一样。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/authorization-management/getAuthorizerInfo.html
     * api: https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_info?access_token=ACCESS_TOKEN
     *
     * @param huoQuShouQuanZhangHaoXiangQingRequest
     */
    HuoQuShouQuanZhangHaoXiangQingResponse huoQuShouQuanZhangHaoXiangQing(HuoQuShouQuanZhangHaoXiangQingRequest huoQuShouQuanZhangHaoXiangQingRequest);

    /**
     * 设置授权方选项信息
     * descr: 本 API 用于设置授权方的公众号/小程序的选项信息，如：地理位置上报，语音识别开关，多客服开关。使用过程中如遇到问题，可在,发帖交流,注意： 设置各项选项设置信息，需要有授权方的授权，详见权限集说明。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/authorization-management/setAuthorizerOptionInfo.html
     * api: https://api.weixin.qq.com/cgi-bin/component/set_authorizer_option?access_token=ACCESS_TOKEN
     *
     * @param sheZhiShouQuanFangXuanXiangXinXiRequest
     */
    SheZhiShouQuanFangXuanXiangXinXiResponse sheZhiShouQuanFangXuanXiangXinXi(SheZhiShouQuanFangXuanXiangXinXiRequest sheZhiShouQuanFangXuanXiangXinXiRequest);

    /**
     * 获取授权方选项信息
     * descr: 本 API 用于获取授权方的公众号/小程序的选项设置信息，如：地理位置上报，语音识别开关，多客服开关。使用过程中如遇到问题，可在,发帖交流
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/authorization-management/getAuthorizerOptionInfo.html
     * api: https://api.weixin.qq.com/cgi-bin/component/get_authorizer_option?access_token=ACCESS_TOKEN
     *
     * @param huoQuShouQuanFangXuanXiangXinXiRequest
     */
    HuoQuShouQuanFangXuanXiangXinXiResponse huoQuShouQuanFangXuanXiangXinXi(HuoQuShouQuanFangXuanXiangXinXiRequest huoQuShouQuanFangXuanXiangXinXiRequest);
}