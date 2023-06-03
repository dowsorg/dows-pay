package org.dows.sdk.weixin.pay.fxhg;

import org.dows.sdk.weixin.pay.fxhg.request.ChaXunShenQingDanShenHeJieGuoRequest;
import org.dows.sdk.weixin.pay.fxhg.request.CheXiaoShenQingDanRequest;
import org.dows.sdk.weixin.pay.fxhg.request.HuoQuShangHuKaiHuYiYuanQueRenZhuangTaiRequest;
import org.dows.sdk.weixin.pay.fxhg.request.TiJiaoShenQingDanRequest;
import org.dows.sdk.weixin.pay.fxhg.response.ChaXunShenQingDanShenHeJieGuoResponse;
import org.dows.sdk.weixin.pay.fxhg.response.CheXiaoShenQingDanResponse;
import org.dows.sdk.weixin.pay.fxhg.response.HuoQuShangHuKaiHuYiYuanQueRenZhuangTaiResponse;
import org.dows.sdk.weixin.pay.fxhg.response.TiJiaoShenQingDanResponse;

/**
 * 商户开户意愿确认
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:53
 */
public interface ShangHuKaiHuYiYuanQueRenApi {

    /**
     * 提交申请单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter10_1_1.shtml
     * api:
     *
     * @param tiJiaoShenQingDanRequest
     */
    TiJiaoShenQingDanResponse tiJiaoShenQingDan(TiJiaoShenQingDanRequest tiJiaoShenQingDanRequest);

    /**
     * 撤销申请单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter10_1_2.shtml
     * api:
     *
     * @param cheXiaoShenQingDanRequest
     */
    CheXiaoShenQingDanResponse cheXiaoShenQingDan(CheXiaoShenQingDanRequest cheXiaoShenQingDanRequest);

    /**
     * 查询申请单审核结果
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter10_1_3.shtml
     * api:
     *
     * @param chaXunShenQingDanShenHeJieGuoRequest
     */
    ChaXunShenQingDanShenHeJieGuoResponse chaXunShenQingDanShenHeJieGuo(ChaXunShenQingDanShenHeJieGuoRequest chaXunShenQingDanShenHeJieGuoRequest);

    /**
     * 获取商户开户意愿确认状态
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter10_1_4.shtml
     * api:
     *
     * @param huoQuShangHuKaiHuYiYuanQueRenZhuangTaiRequest
     */
    HuoQuShangHuKaiHuYiYuanQueRenZhuangTaiResponse huoQuShangHuKaiHuYiYuanQueRenZhuangTai(HuoQuShangHuKaiHuYiYuanQueRenZhuangTaiRequest huoQuShangHuKaiHuYiYuanQueRenZhuangTaiRequest);
}