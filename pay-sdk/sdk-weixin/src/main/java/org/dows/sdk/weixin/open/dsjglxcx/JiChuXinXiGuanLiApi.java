package org.dows.sdk.weixin.open.dsjglxcx;

import org.dows.sdk.weixin.open.dsjglxcx.request.*;
import org.dows.sdk.weixin.open.dsjglxcx.response.*;

/**
 * 基础信息管理
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface JiChuXinXiGuanLiApi {

    /**
     * 获取基本信息
     * descr: 调用本 API 可以获取小程序的基本信息，所属权限集为30。使用过程中如遇到问题，可在开放平台服务商专区发帖交流。,补充：该接口同适用于获取公众号基本信息，所属权限集为3；
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/getAccountBasicInfo.html
     * api: https://api.weixin.qq.com/cgi-bin/account/getaccountbasicinfo?access_token=ACCESS_TOKEN
     *
     * @param huoQuJiBenXinXiRequest
     */
    HuoQuJiBenXinXiResponse huoQuJiBenXinXi(HuoQuJiBenXinXiRequest huoQuJiBenXinXiRequest);

    /**
     * 查询绑定的开放平台帐号
     * descr: 该 API 用于查询公众号或小程序是否绑定的开放平台帐号。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/getBindOpenAccount.html
     * api: https://api.weixin.qq.com/cgi-bin/open/have?access_token=ACCESS_TOKEN
     *
     * @param chaXunBangDingDeKaiFangPingTaiZhangHaoRequest
     */
    ChaXunBangDingDeKaiFangPingTaiZhangHaoResponse chaXunBangDingDeKaiFangPingTaiZhangHao(ChaXunBangDingDeKaiFangPingTaiZhangHaoRequest chaXunBangDingDeKaiFangPingTaiZhangHaoRequest);

    /**
     * 小程序名称检测
     * descr: 调用本 API 可以检测微信认证的名称是否符合规则。使用过程中如遇到问题，可在,发帖交流,该接口只允许通过api创建的小程序使用。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/checkNickName.html
     * api: https://api.weixin.qq.com/cgi-bin/wxverify/checkwxverifynickname?access_token=ACCESS_TOKEN
     *
     * @param xiaoChengXuMingChengJianCeRequest
     */
    XiaoChengXuMingChengJianCeResponse xiaoChengXuMingChengJianCe(XiaoChengXuMingChengJianCeRequest xiaoChengXuMingChengJianCeRequest);

    /**
     * 设置小程序名称
     * descr: 的审核结果会向消息与事件接收 URL 推送相关通知。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/setNickName.html
     * api: https://api.weixin.qq.com/wxa/setnickname?access_token=ACCESS_TOKEN
     *
     * @param sheZhiXiaoChengXuMingChengRequest
     */
    SheZhiXiaoChengXuMingChengResponse sheZhiXiaoChengXuMingCheng(SheZhiXiaoChengXuMingChengRequest sheZhiXiaoChengXuMingChengRequest);

    /**
     * 查询小程序名称审核状态
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/getNickNameStatus.html
     * api: https://api.weixin.qq.com/wxa/api_wxa_querynickname?access_token=ACCESS_TOKEN
     *
     * @param chaXunXiaoChengXuMingChengShenHeZhuangTaiRequest
     */
    ChaXunXiaoChengXuMingChengShenHeZhuangTaiResponse chaXunXiaoChengXuMingChengShenHeZhuangTai(ChaXunXiaoChengXuMingChengShenHeZhuangTaiRequest chaXunXiaoChengXuMingChengShenHeZhuangTaiRequest);

    /**
     * 设置小程序介绍
     * descr: 调用本接口可以修改功能介绍。使用过程中如遇到问题，可在,发帖交流。,报错53204请注意： 1、signature长度4~120。 2、signature至少4个字的中文描述。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/setSignature.html
     * api: https://api.weixin.qq.com/cgi-bin/account/modifysignature?access_token=ACCESS_TOKEN
     *
     * @param sheZhiXiaoChengXuJieShaoRequest
     */
    SheZhiXiaoChengXuJieShaoResponse sheZhiXiaoChengXuJieShao(SheZhiXiaoChengXuJieShaoRequest sheZhiXiaoChengXuJieShaoRequest);

    /**
     * 获取搜索状态
     * descr: 通过本接口可以查询小程序当前是否可被搜索。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/getSearchStatus.html
     * api: https://api.weixin.qq.com/wxa/getwxasearchstatus?access_token=ACCESS_TOKEN
     *
     * @param huoQuSouSuoZhuangTaiRequest
     */
    HuoQuSouSuoZhuangTaiResponse huoQuSouSuoZhuangTai(HuoQuSouSuoZhuangTaiRequest huoQuSouSuoZhuangTaiRequest);

    /**
     * 设置搜索状态
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/setSearchStatus.html
     * api: https://api.weixin.qq.com/wxa/changewxasearchstatus?access_token=ACCESS_TOKEN
     *
     * @param sheZhiSouSuoZhuangTaiRequest
     */
    SheZhiSouSuoZhuangTaiResponse sheZhiSouSuoZhuangTai(SheZhiSouSuoZhuangTaiRequest sheZhiSouSuoZhuangTaiRequest);

    /**
     * 数据预拉取和数据周期性更新
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/getFetchdataSetting.html
     * api: https://api.weixin.qq.com/wxa/fetchdatasetting?access_token=ACCESS_TOKEN
     *
     * @param shuJuYuLaQuHeShuJuZhouQiXingGengXinRequest
     */
    ShuJuYuLaQuHeShuJuZhouQiXingGengXinResponse shuJuYuLaQuHeShuJuZhouQiXingGengXin(ShuJuYuLaQuHeShuJuZhouQiXingGengXinRequest shuJuYuLaQuHeShuJuZhouQiXingGengXinRequest);

    /**
     * 修改头像
     * descr: head_img_media_id：media_id 临时素材 media_id 通过调用“临时素材管理接口”获取 . 调用如下接口时请使用,。请注意：这里需使用authorizer_access_token调用以下接口获取的media_id（小程序AccessToken、公众号AccessToken、第三方平台令牌component_access_token调用以下接口获取的media_id都不行！）才能用到head_img_media_id参数值中，否则会报错40007
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/setHeadImage.html
     * api: https://api.weixin.qq.com/cgi-bin/account/modifyheadimage?access_token=ACCESS_TOKEN
     *
     * @param xiuGaiTouXiangRequest
     */
    XiuGaiTouXiangResponse xiuGaiTouXiang(XiuGaiTouXiangRequest xiuGaiTouXiangRequest);

    /**
     * 查询开放平台帐号是否与小程序同主体
     * descr: 该 API 用于查询公众号或小程序绑定的开放平台帐号是否与当前公众号/小程序同主体。使用过程中如遇到问题，可在开放平台服务商专区发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/getBindOpenAccountEntity.html
     * api: https://api.weixin.qq.com/cgi-bin/open/sameentity?access_token=ACCESS_TOKEN
     *
     * @param chaXunKaiFangPingTaiZhangHaoShiFouYuXiaoChengXuTongZhuTiRequest
     */
    ChaXunKaiFangPingTaiZhangHaoShiFouYuXiaoChengXuTongZhuTiResponse chaXunKaiFangPingTaiZhangHaoShiFouYuXiaoChengXuTongZhuTi(ChaXunKaiFangPingTaiZhangHaoShiFouYuXiaoChengXuTongZhuTiRequest chaXunKaiFangPingTaiZhangHaoShiFouYuXiaoChengXuTongZhuTiRequest);

    /**
     * 获取订单页path信息
     * descr: 该接口用于获取订单页path信息。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/getOrderPathInfo.html
     * api: https://api.weixin.qq.com/wxa/security/getorderpathinfo?access_token=ACCESS_TOKEN
     *
     * @param huoQuDingDanYepathXinXiRequest
     */
    HuoQuDingDanYepathXinXiResponse huoQuDingDanYepathXinXi(HuoQuDingDanYepathXinXiRequest huoQuDingDanYepathXinXiRequest);

    /**
     * 申请设置订单页path信息
     * descr: 该接口用于申请设置订单页path信息,appid_list：一次提交不超过100个appid,返回码说明
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/applySetOrderPathInfo.html
     * api: https://api.weixin.qq.com/wxa/security/applysetorderpathinfo?component_access_token=COMPONENT_ACCESS_TOKEN
     *
     * @param shenQingSheZhiDingDanYepathXinXiRequest
     */
    ShenQingSheZhiDingDanYepathXinXiResponse shenQingSheZhiDingDanYepathXinXi(ShenQingSheZhiDingDanYepathXinXiRequest shenQingSheZhiDingDanYepathXinXiRequest);
}