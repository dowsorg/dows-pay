package org.dows.sdk.weixin.open.dsjglxcx;

import org.dows.sdk.weixin.open.dsjglxcx.request.*;
import org.dows.sdk.weixin.open.dsjglxcx.response.*;

/**
 * 小程序代码管理
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface XiaoChengXuDaiMaGuanLiApi {

    /**
     * 上传代码并生成体验版
     * descr: 补充说明：,特殊字段说明：
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/commit.html
     * api: https://api.weixin.qq.com/wxa/commit?access_token=ACCESS_TOKEN
     *
     * @param shangChuanDaiMaBingShengChengTiYanBanRequest
     */
    ShangChuanDaiMaBingShengChengTiYanBanResponse shangChuanDaiMaBingShengChengTiYanBan(ShangChuanDaiMaBingShengChengTiYanBanRequest shangChuanDaiMaBingShengChengTiYanBanRequest);

    /**
     * 获取已上传的代码页面列表
     * descr: 通过本接口可以获取由commit接口上传代码的页面列表；使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/getCodePage.html
     * api: https://api.weixin.qq.com/wxa/get_page?access_token=ACCESS_TOKEN
     *
     * @param huoQuYiShangChuanDeDaiMaYeMianLieBiaoRequest
     */
    HuoQuYiShangChuanDeDaiMaYeMianLieBiaoResponse huoQuYiShangChuanDeDaiMaYeMianLieBiao(HuoQuYiShangChuanDeDaiMaYeMianLieBiaoRequest huoQuYiShangChuanDeDaiMaYeMianLieBiaoRequest);

    /**
     * 获取体验版二维码
     * descr: 调用本接口可以获取小程序的体验版二维码。使用过程中如遇到问题，可在,发帖交流。,请求正常的情况下，开发者可以直接将返回的二进制结果（response body）保存成图片。返回的 HTTP 头如下：
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/getTrialQRCode.html
     * api: https://api.weixin.qq.com/wxa/get_qrcode?access_token=ACCESS_TOKEN,HTTP/1.1 200 OK Connection: close Content-Type: image/jpeg Content-disposition: attachment; filename="QRCode.jpg" Date: Sun, 06 Jan 2013 10:20:18 GMT Cache-Control: no-cache, must-revalidate Content-Length: 339721
     *
     * @param huoQuTiYanBanErWeiMaRequest
     */
    HuoQuTiYanBanErWeiMaResponse huoQuTiYanBanErWeiMa(HuoQuTiYanBanErWeiMaRequest huoQuTiYanBanErWeiMaRequest);

    /**
     * 提交代码审核
     * descr: 当小程序有审核结果后，微信服务器会向第三方平台方的消息与事件接收 URL（创建第三方平台时填写）以,的方式推送相关通知,接收,请求后，只需直接返回字符串,。为了加强安全性，postdata 中的 xml 将使用服务申请时的加解密 key 来进行加密，具体请见,, 在收到推送后需进行解密（详细请见,）,,除了消息通知之外，第三方平台也可通过接口,、
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/submitAudit.html
     * api: https://api.weixin.qq.com/wxa/submit_audit?access_token=ACCESS_TOKEN
     *
     * @param tiJiaoDaiMaShenHeRequest
     */
    TiJiaoDaiMaShenHeResponse tiJiaoDaiMaShenHe(TiJiaoDaiMaShenHeRequest tiJiaoDaiMaShenHeRequest);

    /**
     * 查询审核单状态
     * descr: 通过接口提交审核后，调用本接口可以查询指定发布审核单的审核状态。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/getAuditStatus.html
     * api: https://api.weixin.qq.com/wxa/get_auditstatus?access_token=ACCESS_TOKEN
     *
     * @param chaXunShenHeDanZhuangTaiRequest
     */
    ChaXunShenHeDanZhuangTaiResponse chaXunShenHeDanZhuangTai(ChaXunShenHeDanZhuangTaiRequest chaXunShenHeDanZhuangTaiRequest);

    /**
     * 撤回代码审核
     * descr: 调用本接口可以撤回当前的代码审核单。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/undoAudit.html
     * api: https://api.weixin.qq.com/wxa/undocodeaudit?access_token=ACCESS_TOKEN
     *
     * @param cheHuiDaiMaShenHeRequest
     */
    CheHuiDaiMaShenHeResponse cheHuiDaiMaShenHe(CheHuiDaiMaShenHeRequest cheHuiDaiMaShenHeRequest);

    /**
     * 发布已通过审核的小程序
     * descr: 调用本接口可以发布最后一个审核通过的小程序代码版本。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/release.html
     * api: https://api.weixin.qq.com/wxa/release?access_token=ACCESS_TOKEN
     *
     * @param faBuYiTongGuoShenHeDeXiaoChengXuRequest
     */
    FaBuYiTongGuoShenHeDeXiaoChengXuResponse faBuYiTongGuoShenHeDeXiaoChengXu(FaBuYiTongGuoShenHeDeXiaoChengXuRequest faBuYiTongGuoShenHeDeXiaoChengXuRequest);

    /**
     * 小程序版本回退
     * descr: 调用本接口可以将小程序的线上版本进行回退。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/revertCodeRelease.html
     * api: https://api.weixin.qq.com/wxa/revertcoderelease?access_token=ACCESS_TOKEN
     *
     * @param xiaoChengXuBanBenHuiTuiRequest
     */
    XiaoChengXuBanBenHuiTuiResponse xiaoChengXuBanBenHuiTui(XiaoChengXuBanBenHuiTuiRequest xiaoChengXuBanBenHuiTuiRequest);

    /**
     * 分阶段发布
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/grayRelease.html
     * api: https://api.weixin.qq.com/wxa/grayrelease?access_token=ACCESS_TOKEN
     *
     * @param fenJieDuanFaBuRequest
     */
    FenJieDuanFaBuResponse fenJieDuanFaBu(FenJieDuanFaBuRequest fenJieDuanFaBuRequest);

    /**
     * 获取分阶段发布详情
     * descr: 该接口用于查询当前分阶段发布详情
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/getGrayReleasePlan.html
     * api: https://api.weixin.qq.com/wxa/getgrayreleaseplan?access_token=ACCESS_TOKEN
     *
     * @param huoQuFenJieDuanFaBuXiangQingRequest
     */
    HuoQuFenJieDuanFaBuXiangQingResponse huoQuFenJieDuanFaBuXiangQing(HuoQuFenJieDuanFaBuXiangQingRequest huoQuFenJieDuanFaBuXiangQingRequest);

    /**
     * 设置小程序服务状态
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/setVisitStatus.html
     * api: https://api.weixin.qq.com/wxa/change_visitstatus?access_token=ACCESS_TOKEN
     *
     * @param sheZhiXiaoChengXuFuWuZhuangTaiRequest
     */
    SheZhiXiaoChengXuFuWuZhuangTaiResponse sheZhiXiaoChengXuFuWuZhuangTai(SheZhiXiaoChengXuFuWuZhuangTaiRequest sheZhiXiaoChengXuFuWuZhuangTaiRequest);

    /**
     * 取消分阶段发布
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/revertGrayRelease.html
     * api: https://api.weixin.qq.com/wxa/revertgrayrelease?access_token=ACCESS_TOKEN
     *
     * @param quXiaoFenJieDuanFaBuRequest
     */
    QuXiaoFenJieDuanFaBuResponse quXiaoFenJieDuanFaBu(QuXiaoFenJieDuanFaBuRequest quXiaoFenJieDuanFaBuRequest);

    /**
     * 查询小程序服务状态
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/getVisitStatus.html
     * api: https://api.weixin.qq.com/wxa/getvisitstatus?access_token=ACCESS_TOKEN
     *
     * @param chaXunXiaoChengXuFuWuZhuangTaiRequest
     */
    ChaXunXiaoChengXuFuWuZhuangTaiResponse chaXunXiaoChengXuFuWuZhuangTai(ChaXunXiaoChengXuFuWuZhuangTaiRequest chaXunXiaoChengXuFuWuZhuangTaiRequest);

    /**
     * 查询各版本用户占比
     * descr: 调用本接口可以查询小程序当前设置的最低基础库版本，以及小程序在各个基础库版本的用户占比。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/getSupportVersion.html
     * api: https://api.weixin.qq.com/cgi-bin/wxopen/getweappsupportversion?access_token=ACCESS_TOKEN
     *
     * @param chaXunGeBanBenYongHuZhanBiRequest
     */
    ChaXunGeBanBenYongHuZhanBiResponse chaXunGeBanBenYongHuZhanBi(ChaXunGeBanBenYongHuZhanBiRequest chaXunGeBanBenYongHuZhanBiRequest);

    /**
     * 设置最低基础库版本
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/setSupportVersion.html
     * api: https://api.weixin.qq.com/cgi-bin/wxopen/setweappsupportversion?access_token=ACCESS_TOKEN
     *
     * @param sheZhiZuiDiJiChuKuBanBenRequest
     */
    SheZhiZuiDiJiChuKuBanBenResponse sheZhiZuiDiJiChuKuBanBen(SheZhiZuiDiJiChuKuBanBenRequest sheZhiZuiDiJiChuKuBanBenRequest);

    /**
     * 查询服务商审核额度
     * descr: 服务商可以调用该接口，查询当月平台分配的提审限额和剩余可提审次数，以及当月分配的审核加急次数和剩余加急次数。（所有旗下小程序共用该额度） 使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/setCodeAuditQuota.html
     * api: https://api.weixin.qq.com/wxa/queryquota?access_token=ACCESS_TOKEN
     *
     * @param chaXunFuWuShangShenHeEDuRequest
     */
    ChaXunFuWuShangShenHeEDuResponse chaXunFuWuShangShenHeEDu(ChaXunFuWuShangShenHeEDuRequest chaXunFuWuShangShenHeEDuRequest);

    /**
     * 加急代码审核
     * descr: 有加急次数的第三方可以通过该接口，对已经提审的小程序进行加急操作，加急后的小程序预计2-12小时内审完。但是若代码中包含较复杂逻辑或其他特殊情况，可能会导致审核时间延长。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/speedupCodeAudit.html
     * api: https://api.weixin.qq.com/wxa/speedupaudit?access_token=ACCESS_TOKEN
     *
     * @param jiaJiDaiMaShenHeRequest
     */
    JiaJiDaiMaShenHeResponse jiaJiDaiMaShenHe(JiaJiDaiMaShenHeRequest jiaJiDaiMaShenHeRequest);

    /**
     * 查询小程序版本信息
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/getVersionInfo.html
     * api: https://api.weixin.qq.com/wxa/getversioninfo?access_token=ACCESS_TOKEN
     *
     * @param chaXunXiaoChengXuBanBenXinXiRequest
     */
    ChaXunXiaoChengXuBanBenXinXiResponse chaXunXiaoChengXuBanBenXinXi(ChaXunXiaoChengXuBanBenXinXiRequest chaXunXiaoChengXuBanBenXinXiRequest);

    /**
     * 查询最新一次审核单状态
     * descr: 调用本接口可以查询最新一次提审单的审核状态。使用过程中如遇到问题，可在,发帖交流
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/getLatestAuditStatus.html
     * api: https://api.weixin.qq.com/wxa/get_latest_auditstatus?access_token=ACCESS_TOKEN
     *
     * @param chaXunZuiXinYiCiShenHeDanZhuangTaiRequest
     */
    ChaXunZuiXinYiCiShenHeDanZhuangTaiResponse chaXunZuiXinYiCiShenHeDanZhuangTai(ChaXunZuiXinYiCiShenHeDanZhuangTaiRequest chaXunZuiXinYiCiShenHeDanZhuangTaiRequest);

    /**
     * 上传提审素材
     * descr: 调用本接口可将小程序页面截图和操作录屏上传，提审时带上相关参数，可以帮助审核人员判断
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/uploadMediaToCodeAudit.html
     * api: https://api.weixin.qq.com/wxa/uploadmedia?access_token=ACCESS_TOKEN
     *
     * @param shangChuanTiShenSuCaiRequest
     */
    ShangChuanTiShenSuCaiResponse shangChuanTiShenSuCai(ShangChuanTiShenSuCaiRequest shangChuanTiShenSuCaiRequest);

    /**
     * 获取隐私接口检测结果
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/getCodePrivacyInfo.html
     * api: https://api.weixin.qq.com/wxa/security/get_code_privacy_info?access_token=ACCESS_TOKEN
     *
     * @param huoQuYinSiJieKouJianCeJieGuoRequest
     */
    HuoQuYinSiJieKouJianCeJieGuoResponse huoQuYinSiJieKouJianCeJieGuo(HuoQuYinSiJieKouJianCeJieGuoRequest huoQuYinSiJieKouJianCeJieGuoRequest);
}