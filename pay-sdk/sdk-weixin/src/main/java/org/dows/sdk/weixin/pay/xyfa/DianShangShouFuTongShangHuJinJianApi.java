package org.dows.sdk.weixin.pay.xyfa;

import org.dows.sdk.weixin.pay.xyfa.request.*;
import org.dows.sdk.weixin.pay.xyfa.response.*;

/**
 * 电商收付通（商户进件）
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:51
 */
public interface DianShangShouFuTongShangHuJinJianApi {

    /**
     * 二级商户进件
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_1_1.shtml
     * api:
     *
     * @param erJiShangHuJinJianRequest
     */
    ErJiShangHuJinJianResponse erJiShangHuJinJian(ErJiShangHuJinJianRequest erJiShangHuJinJianRequest);

    /**
     * 查询申请状态
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_1_2.shtml
     * api:
     *
     * @param chaXunShenQingZhuangTaiRequest
     */
    ChaXunShenQingZhuangTaiResponse chaXunShenQingZhuangTai(ChaXunShenQingZhuangTaiRequest chaXunShenQingZhuangTaiRequest);

    /**
     * 下载平台证书
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_1_3.shtml
     * api:
     *
     * @param xiaZaiPingTaiZhengShuRequest
     */
    XiaZaiPingTaiZhengShuResponse xiaZaiPingTaiZhengShu(XiaZaiPingTaiZhengShuRequest xiaZaiPingTaiZhengShuRequest);

    /**
     * 修改结算账号
     * descr:
     * doc: https://pay.weixin.qq.com/docs/partner/apis/modify-settlement/sub-merchants/modify-settlement.html
     * api:
     *
     * @param xiuGaiJieSuanZhangHaoRequest
     */
    XiuGaiJieSuanZhangHaoResponse xiuGaiJieSuanZhangHao(XiuGaiJieSuanZhangHaoRequest xiuGaiJieSuanZhangHaoRequest);

    /**
     * 查询结算账号
     * descr:
     * doc: https://pay.weixin.qq.com/docs/partner/apis/modify-settlement/sub-merchants/get-settlement.html
     * api:
     *
     * @param chaXunJieSuanZhangHaoRequest
     */
    ChaXunJieSuanZhangHaoResponse chaXunJieSuanZhangHao(ChaXunJieSuanZhangHaoRequest chaXunJieSuanZhangHaoRequest);

    /**
     * 查询结算账户修改申请状态
     * descr:
     * doc: https://pay.weixin.qq.com/docs/partner/apis/modify-settlement/sub-merchants/get-application.html
     * api:
     *
     * @param chaXunJieSuanZhangHuXiuGaiShenQingZhuangTaiRequest
     */
    ChaXunJieSuanZhangHuXiuGaiShenQingZhuangTaiResponse chaXunJieSuanZhangHuXiuGaiShenQingZhuangTai(ChaXunJieSuanZhangHuXiuGaiShenQingZhuangTaiRequest chaXunJieSuanZhangHuXiuGaiShenQingZhuangTaiRequest);
}