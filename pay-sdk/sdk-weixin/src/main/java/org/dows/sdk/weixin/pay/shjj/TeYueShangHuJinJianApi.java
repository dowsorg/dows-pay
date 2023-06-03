package org.dows.sdk.weixin.pay.shjj;

import org.dows.sdk.weixin.pay.shjj.request.*;
import org.dows.sdk.weixin.pay.shjj.response.*;

/**
 * 特约商户进件
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:50
 */
public interface TeYueShangHuJinJianApi {

    /**
     * 提交申请单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter11_1_1.shtml
     * api:
     *
     * @param tiJiaoShenQingDanRequest
     */
    TiJiaoShenQingDanResponse tiJiaoShenQingDan(TiJiaoShenQingDanRequest tiJiaoShenQingDanRequest);

    /**
     * 查询申请单状态
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter11_1_2.shtml
     * api:
     *
     * @param chaXunShenQingDanZhuangTaiRequest
     */
    ChaXunShenQingDanZhuangTaiResponse chaXunShenQingDanZhuangTai(ChaXunShenQingDanZhuangTaiRequest chaXunShenQingDanZhuangTaiRequest);

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